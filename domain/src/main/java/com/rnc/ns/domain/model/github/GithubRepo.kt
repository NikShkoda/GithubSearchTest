package com.rnc.ns.domain.model.github

import com.google.gson.annotations.SerializedName
import com.rnc.ns.domain.model.base.IdEntity

data class GithubRepo(
    override val id: Long,
    val name: String,
    val description: String,
    @SerializedName("html_url") val url: String,
    @SerializedName("stargazers_count") val stars: Int,
    @SerializedName("watchers_count") val watchers: Int,
    val owner: Owner
): IdEntity<Long>

enum class Sort(val value: String) {
    STARTS("stars"), FORKS("forks")
}

enum class Order(val value: String) {
    DESC("desc"), ASC("asc")
}