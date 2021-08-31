package com.alexstephanov.ecabscodechallenge.network.networkmodels

import com.google.gson.annotations.SerializedName

sealed class Payload {
    data class CreateEventPayload(
        val ref: String?,
        @SerializedName("ref_type") val refType: String,
        val description: String?
    ) : Payload()

    data class DeleteEventPayload(
        val ref: String,
        @SerializedName("ref_type") val refType: String
    ) : Payload()

    data class PushEventPayload(@SerializedName("push_id") val pushId: Int, val ref: String) : Payload()
    data class IssuesEventPayload(val action: String, val issue: IssueModel) : Payload()
    data class WatchEventPayload(val action: String) : Payload()
}