package com.alexstephanov.ecabscodechallenge.network.networkmodels

import com.google.gson.annotations.SerializedName

data class ActorModel(
    @SerializedName("display_login")
    val displayLogin: String,
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)