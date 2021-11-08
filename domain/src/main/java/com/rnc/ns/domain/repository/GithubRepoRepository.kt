package com.rnc.ns.domain.repository

import com.rnc.ns.domain.model.github.GithubReposResponse
import com.rnc.ns.domain.model.github.Order
import com.rnc.ns.domain.model.github.Sort
import com.rnc.ns.domain.model.remote.Result

interface GithubRepoRepository {
    suspend fun getGithubRepos(
        query: String,
        sort: Sort,
        order: Order,
        perPage: Int,
        page: Int
    ): Result<GithubReposResponse>
}