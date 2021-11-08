package com.rnc.ns.domain.model.github

import com.google.gson.annotations.SerializedName

data class Owner (
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)