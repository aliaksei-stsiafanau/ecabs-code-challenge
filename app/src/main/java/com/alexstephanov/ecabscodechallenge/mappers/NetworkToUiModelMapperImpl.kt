package com.alexstephanov.ecabscodechallenge.mappers

import com.alexstephanov.ecabscodechallenge.network.networkmodels.*
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.*
import com.alexstephanov.ecabscodechallenge.utils.DateFormatter
import javax.inject.Inject

class NetworkToUiModelMapperImpl @Inject constructor(private val dateFormatter: DateFormatter) :
    NetworkToUiModelMapper {
    override fun map(eventModel: EventModel<out Payload>): EventUiModel =
        when (eventModel) {
            is CreateEventModel -> mapCreateEventListUiModel(eventModel)
            is DeleteEventModel -> mapDeleteEventListUiModel(eventModel)
            is IssuesEventModel -> mapIssuesEventListUiModel(eventModel)
            is PushEventModel -> mapPushEventListUiModel(eventModel)
            is WatchEventModel -> mapWatchEventListUiModel(eventModel)
        }

    private fun mapCreateEventListUiModel(createEventModel: CreateEventModel): CreateEventUiModel =
        CreateEventUiModel(
            createEventModel.id,
            createEventModel.actor.displayLogin,
            createEventModel.actor.login,
            createEventModel.actor.avatarUrl,
            createEventModel.repo.name,
            dateFormatter.formatDate(createEventModel.createdAt),
            createEventModel.payload.ref,
            createEventModel.payload.refType,
            createEventModel.payload.description
        )

    private fun mapDeleteEventListUiModel(deleteEventModel: DeleteEventModel): DeleteEventUiModel =
        DeleteEventUiModel(
            deleteEventModel.id,
            deleteEventModel.actor.displayLogin,
            deleteEventModel.actor.login,
            deleteEventModel.actor.avatarUrl,
            deleteEventModel.repo.name,
            dateFormatter.formatDate(deleteEventModel.createdAt),
            deleteEventModel.payload.ref,
            deleteEventModel.payload.refType
        )

    private fun mapPushEventListUiModel(pushEventModel: PushEventModel): PushEventUiModel =
        PushEventUiModel(
            pushEventModel.id,
            pushEventModel.actor.displayLogin,
            pushEventModel.actor.login,
            pushEventModel.actor.avatarUrl,
            pushEventModel.repo.name,
            dateFormatter.formatDate(pushEventModel.createdAt),
            pushEventModel.payload.ref
        )

    private fun mapIssuesEventListUiModel(issuesEventModel: IssuesEventModel): IssuesEventUiModel =
        IssuesEventUiModel(
            issuesEventModel.id,
            issuesEventModel.actor.displayLogin,
            issuesEventModel.actor.login,
            issuesEventModel.actor.avatarUrl,
            issuesEventModel.repo.name,
            dateFormatter.formatDate(issuesEventModel.createdAt),
            issuesEventModel.payload.action,
            issuesEventModel.payload.issue.title
        )

    private fun mapWatchEventListUiModel(watchEventModel: WatchEventModel): WatchEventUiModel =
        WatchEventUiModel(
            watchEventModel.id,
            watchEventModel.actor.displayLogin,
            watchEventModel.actor.login,
            watchEventModel.actor.avatarUrl,
            watchEventModel.repo.name,
            dateFormatter.formatDate(watchEventModel.createdAt),
            watchEventModel.payload.action
        )
}