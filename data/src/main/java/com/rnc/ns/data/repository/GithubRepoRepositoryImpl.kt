package com.rnc.ns.data.repository

import com.rnc.ns.data.remote.datasource.GithubRepoRemoteDataSource
import com.rnc.ns.domain.model.github.GithubReposResponse
import com.rnc.ns.domain.model.github.Order
import com.rnc.ns.domain.model.github.Sort
import com.rnc.ns.domain.model.remote.Result
import com.rnc.ns.domain.repository.GithubRepoRepository

class GithubRepoRepositoryImpl(private val githubRepoRemoteDataSource: GithubRepoRemoteDataSource) :
    GithubRepoRepository {

    override suspend fun getGithubRepos(
        query: String,
        sort: Sort,
        order: Order,
        perPage: Int,
        page: Int
    ): Result<GithubReposResponse> =
        githubRepoRemoteDataSource.getGithubRepos(query, sort, order, perPage, page)

}