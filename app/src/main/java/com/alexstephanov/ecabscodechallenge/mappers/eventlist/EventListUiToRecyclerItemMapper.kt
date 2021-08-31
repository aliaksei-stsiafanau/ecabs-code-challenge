package com.alexstephanov.ecabscodechallenge.mappers.eventlist

import com.alexstephanov.ecabscodechallenge.presentation.OnClickListener
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel

interface EventListUiToRecyclerItemMapper {
    fun map(eventUiModel: EventUiModel, onClickListener: OnClickListener<EventUiModel>): RecyclerItem
}