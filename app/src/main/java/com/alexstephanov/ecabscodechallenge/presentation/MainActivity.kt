package com.alexstephanov.ecabscodechallenge.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.EventListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, EventListFragment())
            }
        }
    }
}