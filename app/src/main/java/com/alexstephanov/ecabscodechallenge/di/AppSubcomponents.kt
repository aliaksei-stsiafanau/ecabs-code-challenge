package com.alexstephanov.ecabscodechallenge.di

import com.alexstephanov.ecabscodechallenge.di.eventdetails.EventDetailsSubcomponent
import com.alexstephanov.ecabscodechallenge.di.eventlist.EventListSubcomponent
import dagger.Module

@Module(subcomponents = [EventListSubcomponent::class, EventDetailsSubcomponent::class])
class AppSubcomponents