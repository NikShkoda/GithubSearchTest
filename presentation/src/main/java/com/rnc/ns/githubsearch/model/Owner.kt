package com.rnc.ns.githubsearch.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(
    val login: String,
    val avatarUrl: String
) : Parcelable