package com.alexstephanov.ecabscodechallenge.mapperstests

import com.alexstephanov.ecabscodechallenge.mappers.NetworkToUiModelMapper
import com.alexstephanov.ecabscodechallenge.mappers.NetworkToUiModelMapperImpl
import com.alexstephanov.ecabscodechallenge.network.networkmodels.*
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.*
import com.alexstephanov.ecabscodechallenge.utils.DateFormatter
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import java.util.*

class NetworkToUiModelMapperTest {

    @Mock
    lateinit var dateFormatter: DateFormatter

    lateinit var networkToUiModelMapper: NetworkToUiModelMapper

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        networkToUiModelMapper = NetworkToUiModelMapperImpl(dateFormatter)
        whenever(dateFormatter.formatDate(any())).thenReturn("5 minutes ago")
    }

    @Test
    fun `test map network create event model to ui create event model not null`() {
        val networkEventModel = CreateEventModel(
            "id",
            "type",
            ActorModel("display_login", "login", "avatar_url"),
            RepoModel("name"),
            Payload.CreateEventPayload(
                "ref",
                "ref_type",
                "description"
            ),
            createdAt = Date(1630337568342)
        )
        val uiEventModel = CreateEventUiModel(
            "id",
            "display_login",
            "login",
            "avatar_url",
            "name",
            "5 minutes ago",
            "ref",
            "ref_type",
            "description"
        )
        val mapResult = networkToUiModelMapper.map(networkEventModel)
        assertEquals(mapResult, uiEventModel)
    }

    @Test
    fun `test map network create event model to ui create event model with nulls`() {
        val networkEventModel = CreateEventModel(
            "id",
            "type",
            ActorModel("display_login", "login", "avatar_url"),
            RepoModel("name"),
            Payload.CreateEventPayload(
                null,
                "ref_type",
                null
            ),
            createdAt = Date(1630337568342)
        )
        val uiEventModel = CreateEventUiModel(
            "id",
            "display_login",
            "login",
            "avatar_url",
            "name",
            "5 minutes ago",
            null,
            "ref_type",
            null
        )
        val mapResult = networkToUiModelMapper.map(networkEventModel)
        assertEquals(mapResult, uiEventModel)
    }

    @Test
    fun `test map network delete event model to ui delete event model`() {
        val networkEventModel = DeleteEventModel(
            "id",
            "type",
            ActorModel("display_login", "login", "avatar_url"),
            RepoModel("name"),
            Payload.DeleteEventPayload(
                "ref",
                "ref_type"
            ),
            createdAt = Date(1630337568342)
        )
        val uiEventModel = DeleteEventUiModel(
            "id",
            "display_login",
            "login",
            "avatar_url",
            "name",
            "5 minutes ago",
            "ref",
            "ref_type"
        )
        val mapResult = networkToUiModelMapper.map(networkEventModel)
        assertEquals(mapResult, uiEventModel)
    }

    @Test
    fun `test map network push event model to recycler push event model`() {
        val networkEventModel = PushEventModel(
            "id",
            "type",
            ActorModel("display_login", "login", "avatar_url"),
            RepoModel("name"),
            Payload.PushEventPayload(
                1,
                "ref"
            ),
            createdAt = Date(1630337568342)
        )
        val uiEventModel = PushEventUiModel(
            "id",
            "display_login",
            "login",
            "avatar_url",
            "name",
            "5 minutes ago",
            "ref"
        )
        val mapResult = networkToUiModelMapper.map(networkEventModel)
        assertEquals(mapResult, uiEventModel)
    }

    @Test
    fun `test map network issues event model to recycler issues event model`() {
        val networkEventModel = IssuesEventModel(
            "id",
            "type",
            ActorModel("display_login", "login", "avatar_url"),
            RepoModel("name"),
            Payload.IssuesEventPayload(
                "action",
                IssueModel("issue_title")
            ),
            createdAt = Date(1630337568342)
        )
        val uiEventModel = IssuesEventUiModel(
            "id",
            "display_login",
            "login",
            "avatar_url",
            "name",
            "5 minutes ago",
            "action",
            "issue_title"
        )
        val mapResult = networkToUiModelMapper.map(networkEventModel)
        assertEquals(mapResult, uiEventModel)
    }

    @Test
    fun `test map network watch event model to recycler watch event model`() {
        val networkEventModel = WatchEventModel(
            "id",
            "type",
            ActorModel("display_login", "login", "avatar_url"),
            RepoModel("name"),
            Payload.WatchEventPayload(
                "action"
            ),
            createdAt = Date(1630337568342)
        )
        val uiEventModel = WatchEventUiModel(
            "id",
            "display_login",
            "login",
            "avatar_url",
            "name",
            "5 minutes ago",
            "action"
        )
        val mapResult = networkToUiModelMapper.map(networkEventModel)
        assertEquals(mapResult, uiEventModel)
    }
}