package com.alexstephanov.ecabscodechallenge.network

import com.alexstephanov.ecabscodechallenge.network.networkmodels.*
import com.alexstephanov.ecabscodechallenge.network.networkmodels.IssuesEventModel
import com.alexstephanov.ecabscodechallenge.utils.fromJson
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class EventJsonDeserializer : JsonDeserializer<EventModel<out Payload>?> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): EventModel<out Payload>? = if (json == null) {
        null
    } else {
        when (EventTypes.getFromType(json.asJsonObject.get("type").asString)) {
            EventTypes.CREATE_EVENT_TYPE -> {
                json.fromJson<CreateEventModel>(Gson())
            }
            EventTypes.DELETE_EVENT_TYPE -> {
                json.fromJson<DeleteEventModel>(Gson())
            }
            EventTypes.PUSH_EVENT_TYPE -> {
                json.fromJson<PushEventModel>(Gson())
            }
            EventTypes.ISSUES_EVENT_TYPE -> {
                json.fromJson<IssuesEventModel>(Gson())
            }
            EventTypes.WATCH_EVENT_TYPE -> {
                json.fromJson<WatchEventModel>(Gson())
            }
            else -> null
        }
    }
}