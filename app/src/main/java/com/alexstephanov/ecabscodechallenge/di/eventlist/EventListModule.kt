package com.alexstephanov.ecabscodechallenge.di.eventlist

import androidx.lifecycle.ViewModel
import com.alexstephanov.ecabscodechallenge.di.ViewModelKey
import com.alexstephanov.ecabscodechallenge.mappers.NetworkToUiModelMapper
import com.alexstephanov.ecabscodechallenge.mappers.NetworkToUiModelMapperImpl
import com.alexstephanov.ecabscodechallenge.mappers.eventlist.EventListUiToRecyclerItemMapper
import com.alexstephanov.ecabscodechallenge.mappers.eventlist.EventListUiToRecyclerItemMapperImpl
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.EventListRepository
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.EventListRepositoryImpl
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.EventListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface EventListModule {

    @EventListScope
    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel::class)
    fun bindEventListViewModel(eventListViewModel: EventListViewModel): ViewModel

    @EventListScope
    @Binds
    fun bindEventListRepository(eventListRepositoryImpl: EventListRepositoryImpl): EventListRepository

    @EventListScope
    @Binds
    fun bindNetworkToUiModelMapper(networkToUiModelMapperImpl: NetworkToUiModelMapperImpl): NetworkToUiModelMapper

    @EventListScope
    @Binds
    fun bindEventListUiToRecyclerItemMapper(eventListUiToRecyclerItemMapperImpl: EventListUiToRecyclerItemMapperImpl): EventListUiToRecyclerItemMapper
}