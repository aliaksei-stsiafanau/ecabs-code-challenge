package com.alexstephanov.ecabscodechallenge.presentation.eventlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexstephanov.ecabscodechallenge.mappers.NetworkToUiModelMapper
import com.alexstephanov.ecabscodechallenge.mappers.eventlist.EventListUiToRecyclerItemMapper
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel
import com.alexstephanov.ecabscodechallenge.utils.SingleLiveEvent
import kotlinx.coroutines.*
import javax.inject.Inject

class EventListViewModel @Inject constructor(
    private val eventListRepository: EventListRepository,
    private val networkToUiModelMapper: NetworkToUiModelMapper,
    private val eventListUiToRecyclerItemMapper: EventListUiToRecyclerItemMapper
) : ViewModel() {

    val eventsLiveData: MutableLiveData<Result<List<RecyclerItem>>> = MutableLiveData()
    val clickEvent: SingleLiveEvent<EventUiModel> = SingleLiveEvent()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private var job: Job

    init {
        job = startRequests()
    }

    private fun startRequests(): Job = coroutineScope.launch {
        try {
            while (isActive) {
                val recyclerEvents = loadData()
                eventsLiveData.postValue(Result.success(recyclerEvents))
                delay(10000L)
            }
        } catch (e: Exception) {
            eventsLiveData.postValue(Result.failure(e))
        }
    }

    private suspend fun loadData(): List<RecyclerItem> {
        val events = eventListRepository.retrieveEvents().filterNotNull()
        val uiEvents = events.map { event -> networkToUiModelMapper.map(event) }

        val recyclerEvents = uiEvents.map { uiEvent ->
            eventListUiToRecyclerItemMapper.map(uiEvent) {
                clickEvent.postValue(uiEvent)
            }
        }
        return recyclerEvents
    }

    fun retry() {
        if (job.isActive.not())
            job = startRequests()
    }

    fun onResume() {
        if (job.isActive.not())
            job = startRequests()
    }

    fun onPause() {
        job.cancel()
    }
}