package com.alexstephanov.ecabscodechallenge.di.eventlist

import com.alexstephanov.ecabscodechallenge.presentation.eventlist.EventListFragment
import dagger.Subcomponent

@EventListScope
@Subcomponent(modules = [EventListModule::class])
interface EventListSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): EventListSubcomponent
    }

    fun inject(fragment: EventListFragment)
}