package com.rnc.ns.domain.model.github

import com.google.gson.annotations.SerializedName
import com.rnc.ns.domain.model.github.GithubRepo

data class GithubReposResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<GithubRepo>
)