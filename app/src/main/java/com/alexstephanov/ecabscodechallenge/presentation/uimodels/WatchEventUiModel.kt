package com.alexstephanov.ecabscodechallenge.presentation.uimodels

import kotlinx.parcelize.Parcelize

@Parcelize
data class WatchEventUiModel(
    override val id: String,
    override val displayName: String,
    override val login: String,
    override val avatarUrl: String,
    override val repoName: String,
    override val createdAt: String,
    val action: String
) : EventUiModel(id, displayName, login, avatarUrl, repoName, createdAt)