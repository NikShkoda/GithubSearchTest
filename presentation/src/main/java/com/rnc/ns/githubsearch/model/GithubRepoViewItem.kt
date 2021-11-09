package com.rnc.ns.githubsearch.model

import android.os.Parcelable
import com.rnc.ns.githubsearch.model.base.ViewItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepoViewItem(
    override val id: Long,
    val name: String,
    val description: String,
    val url: String,
    val stars: Int,
    val watchers: Int,
    val score: Int,
    val ownerViewItem: OwnerViewItem
): ViewItem<Long>, Parcelable