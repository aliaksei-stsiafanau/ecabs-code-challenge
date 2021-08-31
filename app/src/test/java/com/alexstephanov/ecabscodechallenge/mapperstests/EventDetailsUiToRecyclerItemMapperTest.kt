package com.alexstephanov.ecabscodechallenge.mapperstests

import com.alexstephanov.ecabscodechallenge.mappers.eventdetails.EventDetailsUiToRecyclerItemMapper
import com.alexstephanov.ecabscodechallenge.mappers.eventdetails.EventDetailsUiToRecyclerItemMapperImpl
import com.alexstephanov.ecabscodechallenge.presentation.eventdetails.recycleritems.*
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EventDetailsUiToRecyclerItemMapperTest {

    private lateinit var eventDetailsUiToRecyclerItemMapper: EventDetailsUiToRecyclerItemMapper

    @Before
    fun setup() {
        eventDetailsUiToRecyclerItemMapper = EventDetailsUiToRecyclerItemMapperImpl()
    }

    @Test
    fun `test map ui create event model to recycler section create item`() {
        val uiEventModel = CreateEventUiModel(
            "id",
            "display_name",
            "login",
            "avatar_url",
            "repo_name",
            "created_at",
            "ref",
            "ref_type",
            "description"
        )
        val mapResult = eventDetailsUiToRecyclerItemMapper.map(uiEventModel)
        assertEquals((mapResult[1] as CreateEventSectionItem).createEventUiModel, uiEventModel)
    }

    @Test
    fun `test map ui delete event model to recycler section delete item`() {
        val uiEventModel = DeleteEventUiModel(
            "id",
            "display_name",
            "login",
            "avatar_url",
            "repo_name",
            "created_at",
            "ref",
            "ref_type"
        )
        val mapResult = eventDetailsUiToRecyclerItemMapper.map(uiEventModel)
        assertEquals((mapResult[1] as DeleteEventSectionItem).deleteEventUiModel, uiEventModel)
    }

    @Test
    fun `test map ui push event model to recycler section push item`() {
        val uiEventModel = PushEventUiModel(
            "id",
            "display_name",
            "login",
            "avatar_url",
            "repo_name",
            "created_at",
            "ref"
        )
        val mapResult = eventDetailsUiToRecyclerItemMapper.map(uiEventModel)
        assertEquals((mapResult[1] as PushEventSectionItem).pushEventUiModel, uiEventModel)
    }

    @Test
    fun `test map ui issues event model to recycler section issues item`() {
        val uiEventModel = IssuesEventUiModel(
            "id",
            "display_name",
            "login",
            "avatar_url",
            "repo_name",
            "created_at",
            "action",
            "issue_title"
        )
        val mapResult = eventDetailsUiToRecyclerItemMapper.map(uiEventModel)
        assertEquals((mapResult[1] as IssuesEventSectionItem).issuesEventUiModel, uiEventModel)
    }

    @Test
    fun `test map ui watch event model to recycler section watch item`() {
        val uiEventModel = WatchEventUiModel(
            "id",
            "display_name",
            "login",
            "avatar_url",
            "repo_name",
            "created_at",
            "action"
        )
        val mapResult = eventDetailsUiToRecyclerItemMapper.map(uiEventModel)
        assertEquals((mapResult[1] as WatchEventSectionItem).watchEventUiModel, uiEventModel)
    }
}