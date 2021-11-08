package com.rnc.ns.githubsearch.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rnc.ns.domain.model.remote.Result
import com.rnc.ns.domain.usecase.GetGithubReposUseCase
import com.rnc.ns.githubsearch.manager.ScoreManager
import com.rnc.ns.githubsearch.mapper.GithubMapper.toGithubRepo
import com.rnc.ns.githubsearch.model.GithubRepo

class GithubRepoPagingSource(
    private val repositoriesUseCase: GetGithubReposUseCase,
    private val query: String
) : PagingSource<Int, GithubRepo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubRepo> {
        return try {
            val pageNumber = params.key ?: 1
            val perPage = params.loadSize
            val response = repositoriesUseCase(
                query = query,
                perPage = perPage,
                page = pageNumber
            )
            when (response.status) {
                Result.Status.SUCCESS -> {
                    response.data?.let { response ->
                        if (response.totalCount == 0) {
                            LoadResult.Error(Throwable("No results"))
                        } else {
                            LoadResult.Page(
                                data = response.items.map { githubRepo -> githubRepo.toGithubRepo() }
                                    .let { githubRepos ->
                                        ScoreManager.updateMaxScore(githubRepos.maxOf { repository -> repository.score() })
                                        githubRepos
                                    },
                                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                                nextKey = pageNumber + 1
                            )
                        }
                    } ?: LoadResult.Error(Throwable("No Results"))
                }
                Result.Status.ERROR -> LoadResult.Error(Throwable(response.errorMessage))
            }
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GithubRepo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}