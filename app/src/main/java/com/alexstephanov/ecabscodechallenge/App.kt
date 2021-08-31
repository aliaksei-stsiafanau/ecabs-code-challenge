package com.alexstephanov.ecabscodechallenge

import android.app.Application
import com.alexstephanov.ecabscodechallenge.di.AppComponent
import com.alexstephanov.ecabscodechallenge.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import timber.log.Timber

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        Timber.plant(Timber.DebugTree())
    }
}