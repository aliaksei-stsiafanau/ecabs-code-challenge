package com.alexstephanov.ecabscodechallenge.di

import com.alexstephanov.ecabscodechallenge.utils.DateFormatter
import com.alexstephanov.ecabscodechallenge.utils.DateFormatterImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface UtilsModule {
    @Singleton
    @Binds
    fun bindDateFormatter(dateFormatterImpl: DateFormatterImpl): DateFormatter
}