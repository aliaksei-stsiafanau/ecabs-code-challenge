package com.alexstephanov.ecabscodechallenge.network.networkmodels

import com.google.gson.annotations.SerializedName
import java.util.*

data class CreateEventModel(
    override val id: String,
    override val type: String,
    override val actor: ActorModel,
    override val repo: RepoModel,
    override val payload: Payload.CreateEventPayload,
    @SerializedName("created_at")
    override val createdAt: Date
) : EventModel<Payload.CreateEventPayload>