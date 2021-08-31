package com.alexstephanov.ecabscodechallenge.api

import com.alexstephanov.ecabscodechallenge.network.networkmodels.EventModel
import com.alexstephanov.ecabscodechallenge.network.networkmodels.Payload
import retrofit2.http.GET

interface ApiService {
    @GET("events")
    suspend fun getEvents(): List<EventModel<out Payload>>
}