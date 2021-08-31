package com.alexstephanov.ecabscodechallenge.presentation.eventdetails

import androidx.lifecycle.ViewModel
import com.alexstephanov.ecabscodechallenge.mappers.eventdetails.EventDetailsUiToRecyclerItemMapper
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel
import javax.inject.Inject

class EventDetailsViewModel @Inject constructor(private val eventDetailsUiToRecyclerItemMapper: EventDetailsUiToRecyclerItemMapper) :
    ViewModel() {

    fun convertUiModelIntoRecyclerItem(eventUiModel: EventUiModel): List<RecyclerItem> =
        eventDetailsUiToRecyclerItemMapper.map(eventUiModel)
}