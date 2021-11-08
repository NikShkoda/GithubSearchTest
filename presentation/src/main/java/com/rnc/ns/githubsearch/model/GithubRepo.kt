package com.rnc.ns.githubsearch.model

import android.os.Parcelable
import com.rnc.ns.domain.model.base.IdEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepo(
    override val id: Long,
    val name: String,
    val description: String,
    val url: String,
    val stars: Int,
    val watchers: Int,
    val owner: Owner
): IdEntity<Long>, Parcelable {
    fun score() = watchers + stars
}