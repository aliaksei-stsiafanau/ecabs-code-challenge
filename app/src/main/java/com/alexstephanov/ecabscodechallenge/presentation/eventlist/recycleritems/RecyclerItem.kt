package com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems

import android.view.View

interface RecyclerItem {
    val viewId: Int
    fun bind(view: View)
    fun areItemsTheSame(newItem: RecyclerItem): Boolean
    fun areContentsTheSame(newItem: RecyclerItem): Boolean
}