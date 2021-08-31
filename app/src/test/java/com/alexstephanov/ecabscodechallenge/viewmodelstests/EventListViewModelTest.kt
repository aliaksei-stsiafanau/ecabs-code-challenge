package com.alexstephanov.ecabscodechallenge.viewmodelstests

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.alexstephanov.ecabscodechallenge.mappers.NetworkToUiModelMapper
import com.alexstephanov.ecabscodechallenge.mappers.eventlist.EventListUiToRecyclerItemMapper
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.EventListRepository
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.EventListViewModel
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class EventListViewModelTest {

    @Mock
    lateinit var eventListRepository: EventListRepository

    @Mock
    lateinit var networkToUiModelMapper: NetworkToUiModelMapper

    @Spy
    lateinit var eventListUiToRecyclerItemMapper: EventListUiToRecyclerItemMapper

    private lateinit var viewModel: EventListViewModel


    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        whenever(eventListUiToRecyclerItemMapper.map(any(), any())).thenReturn(mock())
        whenever(networkToUiModelMapper.map(any())).thenReturn(mock())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test view model success loading data`() = runBlockingTest {
        whenever(eventListRepository.retrieveEvents()).thenReturn(emptyList())
        viewModel = EventListViewModel(
            eventListRepository,
            networkToUiModelMapper,
            eventListUiToRecyclerItemMapper
        )
        assertEquals(
            Result.success<List<RecyclerItem>>(emptyList()),
            viewModel.eventsLiveData.getOrAwaitValue()
        )
    }

    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }

        this.observeForever(observer)

        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }
}