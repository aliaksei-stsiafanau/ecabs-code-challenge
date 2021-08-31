package com.alexstephanov.ecabscodechallenge.network.networkmodels

import java.util.*

sealed interface EventModel<T: Payload> {
    val id: String
    val type: String
    val actor: ActorModel
    val repo: RepoModel
    val payload: T
    val createdAt: Date
}