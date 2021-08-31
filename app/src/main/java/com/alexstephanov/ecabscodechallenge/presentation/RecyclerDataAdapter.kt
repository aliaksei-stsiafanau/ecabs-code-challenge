package com.alexstephanov.ecabscodechallenge.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import javax.inject.Inject

class RecyclerDataAdapter @Inject constructor(): ListAdapter<RecyclerItem, RecyclerView.ViewHolder>(BASE_DIFF_CALLBACK) {

    override fun getItemViewType(position: Int): Int = getItem(position).viewId

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        object : RecyclerView.ViewHolder(parent.viewOf(viewType)) {}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position).bind(holder.itemView)
    }

    private fun ViewGroup.viewOf(@LayoutRes resource: Int): View {
        return LayoutInflater
            .from(context)
            .inflate(resource, this, false)
    }

    companion object {
        val BASE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<RecyclerItem>() {

            override fun areItemsTheSame(
                oldItem: RecyclerItem,
                newItem: RecyclerItem
            ): Boolean = oldItem.areItemsTheSame(newItem)

            override fun areContentsTheSame(
                oldItem: RecyclerItem,
                newItem: RecyclerItem
            ): Boolean = oldItem.areContentsTheSame(newItem)
        }
    }
}