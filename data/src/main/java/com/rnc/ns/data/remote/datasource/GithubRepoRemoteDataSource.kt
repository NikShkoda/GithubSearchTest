package com.rnc.ns.data.remote.datasource

import com.rnc.ns.data.remote.api.GithubApi
import com.rnc.ns.data.remote.utils.apiCall
import com.rnc.ns.domain.model.github.GithubReposResponse
import com.rnc.ns.domain.model.github.Order
import com.rnc.ns.domain.model.github.Sort
import com.rnc.ns.domain.model.remote.Result

class GithubRepoRemoteDataSource(private val api: GithubApi) {
    suspend fun getGithubRepos(
        query: String,
        sort: Sort,
        order: Order,
        perPage: Int,
        page: Int
    ): Result<GithubReposResponse> = apiCall {
        api.getGithubRepositories(
            query,
            sort.value,
            order.value,
            perPage,
            page
        )
    }
}