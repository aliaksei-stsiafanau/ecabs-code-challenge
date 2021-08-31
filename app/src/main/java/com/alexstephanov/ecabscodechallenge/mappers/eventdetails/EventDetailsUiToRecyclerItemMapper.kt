package com.alexstephanov.ecabscodechallenge.mappers.eventdetails

import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel

interface EventDetailsUiToRecyclerItemMapper {
    fun map(eventUiModel: EventUiModel): List<RecyclerItem>
}