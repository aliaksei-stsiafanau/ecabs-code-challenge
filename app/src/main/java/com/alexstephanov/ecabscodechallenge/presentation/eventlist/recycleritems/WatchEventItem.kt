package com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.WatchEventItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.OnClickListener
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.WatchEventUiModel

class WatchEventItem(
    val watchEventUiModel: WatchEventUiModel,
    private val onClickListener: OnClickListener<EventUiModel>
) : RecyclerItem {

    override val viewId: Int = R.layout.watch_event_item

    override fun bind(view: View) {
        with(WatchEventItemBinding.bind(view)) {
            draweeViewWatchEventItemUserLogo.setImageURI(watchEventUiModel.avatarUrl)
            textViewWatchEventItemDisplayName.text = watchEventUiModel.displayName
            textViewWatchEventItemDescription.text = watchEventUiModel.action
            textViewPushEventItemCreationDate.text =
                watchEventUiModel.createdAt
            view.setOnClickListener { onClickListener.onClick(watchEventUiModel) }
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is WatchEventItem && watchEventUiModel.id == newItem.watchEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is WatchEventItem && watchEventUiModel == newItem.watchEventUiModel
}