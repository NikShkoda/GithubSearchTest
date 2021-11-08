package com.rnc.ns.domain.usecase

import com.rnc.ns.domain.model.github.Order
import com.rnc.ns.domain.model.github.Sort
import com.rnc.ns.domain.repository.GithubRepoRepository

class GetGithubReposUseCase(private val repository: GithubRepoRepository) {
    suspend operator fun invoke(
        query: String,
        sort: Sort = Sort.STARTS,
        order: Order = Order.DESC,
        perPage: Int,
        page: Int
    ) = repository.getGithubRepos(query, sort, order, perPage, page)
}