package com.alexstephanov.ecabscodechallenge.mappers.eventdetails

import com.alexstephanov.ecabscodechallenge.presentation.eventdetails.recycleritems.*
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.*
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.*
import javax.inject.Inject

class EventDetailsUiToRecyclerItemMapperImpl @Inject constructor() : EventDetailsUiToRecyclerItemMapper {
    override fun map(eventUiModel: EventUiModel): List<RecyclerItem> =
        when(eventUiModel) {
            is CreateEventUiModel -> listOf(CommonSectionItem(eventUiModel), CreateEventSectionItem(eventUiModel))
            is DeleteEventUiModel -> listOf(CommonSectionItem(eventUiModel), DeleteEventSectionItem(eventUiModel))
            is IssuesEventUiModel -> listOf(CommonSectionItem(eventUiModel), IssuesEventSectionItem(eventUiModel))
            is PushEventUiModel -> listOf(CommonSectionItem(eventUiModel), PushEventSectionItem(eventUiModel))
            is WatchEventUiModel -> listOf(CommonSectionItem(eventUiModel), WatchEventSectionItem(eventUiModel))
        }
}