package com.alexstephanov.ecabscodechallenge.di.eventdetails

import androidx.lifecycle.ViewModel
import com.alexstephanov.ecabscodechallenge.di.ViewModelKey
import com.alexstephanov.ecabscodechallenge.mappers.eventdetails.EventDetailsUiToRecyclerItemMapper
import com.alexstephanov.ecabscodechallenge.mappers.eventdetails.EventDetailsUiToRecyclerItemMapperImpl
import com.alexstephanov.ecabscodechallenge.presentation.eventdetails.EventDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface EventDetailsModule {

    @EventDetailsScope
    @Binds
    @IntoMap
    @ViewModelKey(EventDetailsViewModel::class)
    fun bindEventDetailsViewModel(eventDetailsViewModel: EventDetailsViewModel): ViewModel

    @EventDetailsScope
    @Binds
    fun bindEventDetailsUiToRecyclerItemMapper(eventDetailsUiToRecyclerItemMapperImpl: EventDetailsUiToRecyclerItemMapperImpl): EventDetailsUiToRecyclerItemMapper
}