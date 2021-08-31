package com.alexstephanov.ecabscodechallenge.presentation.eventlist

import com.alexstephanov.ecabscodechallenge.api.ApiService
import com.alexstephanov.ecabscodechallenge.network.networkmodels.EventModel
import com.alexstephanov.ecabscodechallenge.network.networkmodels.Payload
import javax.inject.Inject

class EventListRepositoryImpl @Inject constructor(private val apiService: ApiService): EventListRepository {
    override suspend fun retrieveEvents(): List<EventModel<out Payload>?> = apiService.getEvents()
}