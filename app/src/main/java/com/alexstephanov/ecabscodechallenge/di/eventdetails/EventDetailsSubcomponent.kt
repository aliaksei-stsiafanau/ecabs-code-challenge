package com.alexstephanov.ecabscodechallenge.di.eventdetails

import com.alexstephanov.ecabscodechallenge.presentation.eventdetails.EventDetailsFragment
import dagger.Subcomponent

@EventDetailsScope
@Subcomponent(modules = [EventDetailsModule::class])
interface EventDetailsSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): EventDetailsSubcomponent
    }

    fun inject(fragment: EventDetailsFragment)
}