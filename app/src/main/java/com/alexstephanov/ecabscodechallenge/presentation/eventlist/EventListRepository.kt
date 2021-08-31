package com.alexstephanov.ecabscodechallenge.presentation.eventlist

import com.alexstephanov.ecabscodechallenge.network.networkmodels.EventModel
import com.alexstephanov.ecabscodechallenge.network.networkmodels.Payload
import kotlin.jvm.Throws

interface EventListRepository {
    suspend fun retrieveEvents(): List<EventModel<out Payload>?>
}