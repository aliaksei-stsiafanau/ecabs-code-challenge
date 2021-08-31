package com.alexstephanov.ecabscodechallenge.presentation.uimodels

import android.os.Parcelable

sealed class EventUiModel(
    open val id: String,
    open val displayName: String,
    open val login: String,
    open val avatarUrl: String,
    open val repoName: String,
    open val createdAt: String
) : Parcelable