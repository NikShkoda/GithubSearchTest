package com.rnc.ns.githubsearch.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OwnerViewItem(
    val login: String,
    val avatarUrl: String
) : Parcelable