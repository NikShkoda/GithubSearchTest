package com.rnc.ns.data.remote.api

import com.rnc.ns.domain.model.github.GithubReposResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/repositories")
    suspend fun getGithubRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Response<GithubReposResponse>

}