package com.alexstephanov.ecabscodechallenge.di

import android.content.Context
import com.alexstephanov.ecabscodechallenge.di.eventdetails.EventDetailsSubcomponent
import com.alexstephanov.ecabscodechallenge.di.eventlist.EventListSubcomponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubcomponents::class, RetrofitModule::class, UtilsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun eventListSubcomponent(): EventListSubcomponent.Factory
    fun eventDetailsSubcomponent(): EventDetailsSubcomponent.Factory
}