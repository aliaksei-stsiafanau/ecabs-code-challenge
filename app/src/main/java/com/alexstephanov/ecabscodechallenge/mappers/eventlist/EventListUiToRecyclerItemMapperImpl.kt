package com.alexstephanov.ecabscodechallenge.mappers.eventlist

import com.alexstephanov.ecabscodechallenge.presentation.OnClickListener
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.*
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.*
import javax.inject.Inject

class EventListUiToRecyclerItemMapperImpl @Inject constructor() : EventListUiToRecyclerItemMapper {
    override fun map(eventUiModel: EventUiModel, onClickListener: OnClickListener<EventUiModel>): RecyclerItem =
        when(eventUiModel) {
            is CreateEventUiModel -> CreateEventItem(eventUiModel, onClickListener)
            is DeleteEventUiModel -> DeleteEventItem(eventUiModel, onClickListener)
            is IssuesEventUiModel -> IssuesEventItem(eventUiModel, onClickListener)
            is PushEventUiModel -> PushEventItem(eventUiModel, onClickListener)
            is WatchEventUiModel -> WatchEventItem(eventUiModel, onClickListener)
        }
}