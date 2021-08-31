package com.alexstephanov.ecabscodechallenge.network.networkmodels

enum class EventTypes(val type: String) {
    CREATE_EVENT_TYPE("CreateEvent"),
    DELETE_EVENT_TYPE("DeleteEvent"),
    PUSH_EVENT_TYPE("PushEvent"),
    ISSUES_EVENT_TYPE("IssuesEvent"),
    WATCH_EVENT_TYPE("WatchEvent");

    companion object {
        fun getFromType(type: String): EventTypes? =
            values().find { it.type == type}
    }
}