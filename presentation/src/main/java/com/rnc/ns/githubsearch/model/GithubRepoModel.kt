package com.rnc.ns.githubsearch.model

import android.os.Parcelable
import com.rnc.ns.domain.model.base.IdEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepoModel(
    override val id: Long,
    val name: String,
    val description: String,
    val url: String,
    val stars: Int,
    val watchers: Int,
    val score: Int,
    val ownerModel: OwnerModel
): IdModel<Long>, Parcelable