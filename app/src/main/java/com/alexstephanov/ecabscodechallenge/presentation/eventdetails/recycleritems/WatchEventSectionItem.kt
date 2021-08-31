package com.alexstephanov.ecabscodechallenge.presentation.eventdetails.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.SectionWatchEventPayloadItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.WatchEventUiModel

class WatchEventSectionItem(val watchEventUiModel: WatchEventUiModel) : RecyclerItem {
    override val viewId: Int = R.layout.section_watch_event_payload_item

    override fun bind(view: View) {
        with(SectionWatchEventPayloadItemBinding.bind(view)) {
            textViewSectionWatchEventPayloadItemInfo.text =
                view.context.getString(R.string.watch_event_description, watchEventUiModel.repoName)
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is WatchEventSectionItem && watchEventUiModel.id == newItem.watchEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is WatchEventSectionItem && watchEventUiModel == newItem.watchEventUiModel
}