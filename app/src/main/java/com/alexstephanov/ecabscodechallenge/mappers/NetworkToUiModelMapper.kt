package com.alexstephanov.ecabscodechallenge.mappers

import com.alexstephanov.ecabscodechallenge.network.networkmodels.*
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.*

interface NetworkToUiModelMapper {
    fun map(eventModel: EventModel<out Payload>): EventUiModel
}