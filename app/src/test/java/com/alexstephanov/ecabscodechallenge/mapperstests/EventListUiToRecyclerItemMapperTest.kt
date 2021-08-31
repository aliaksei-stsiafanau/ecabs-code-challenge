package com.alexstephanov.ecabscodechallenge.mapperstests

import com.alexstephanov.ecabscodechallenge.mappers.eventlist.EventListUiToRecyclerItemMapper
import com.alexstephanov.ecabscodechallenge.mappers.eventlist.EventListUiToRecyclerItemMapperImpl
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.*
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EventListUiToRecyclerItemMapperTest {

    private lateinit var eventListUiToRecyclerItemMapper: EventListUiToRecyclerItemMapper

    @Before
    fun setup() {
        eventListUiToRecyclerItemMapper = EventListUiToRecyclerItemMapperImpl()
    }

    @Test
    fun `test map ui create event model to recycler create event item`() {
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
        val mapResult = eventListUiToRecyclerItemMapper.map(uiEventModel) {}
        assertEquals((mapResult as CreateEventItem).createEventUiModel, uiEventModel)
    }

    @Test
    fun `test map ui delete event model to recycler delete event item`() {
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
        val mapResult = eventListUiToRecyclerItemMapper.map(uiEventModel) {}
        assertEquals((mapResult as DeleteEventItem).deleteEventUiModel, uiEventModel)
    }

    @Test
    fun `test map ui push event model to recycler push event item`() {
        val uiEventModel = PushEventUiModel(
            "id",
            "display_name",
            "login",
            "avatar_url",
            "repo_name",
            "created_at",
            "ref"
        )
        val mapResult = eventListUiToRecyclerItemMapper.map(uiEventModel) {}
        assertEquals((mapResult as PushEventItem).pushEventUiModel, uiEventModel)
    }

    @Test
    fun `test map ui issues event model to recycler issues event item`() {
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
        val mapResult = eventListUiToRecyclerItemMapper.map(uiEventModel) {}
        assertEquals((mapResult as IssuesEventItem).issuesEventUiModel, uiEventModel)
    }

    @Test
    fun `test map ui watch event model to recycler watch event item`() {
        val uiEventModel = WatchEventUiModel(
            "id",
            "display_name",
            "login",
            "avatar_url",
            "repo_name",
            "created_at",
            "action"
        )
        val mapResult = eventListUiToRecyclerItemMapper.map(uiEventModel) {}
        assertEquals((mapResult as WatchEventItem).watchEventUiModel, uiEventModel)
    }
}