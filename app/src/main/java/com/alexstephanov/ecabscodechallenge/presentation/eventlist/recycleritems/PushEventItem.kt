package com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.PushEventItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.OnClickListener
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.PushEventUiModel

class PushEventItem(
    val pushEventUiModel: PushEventUiModel,
    private val onClickListener: OnClickListener<EventUiModel>
) : RecyclerItem {

    override val viewId: Int = R.layout.push_event_item

    override fun bind(view: View) {
        with(PushEventItemBinding.bind(view)) {
            draweeViewPushEventItemUserLogo.setImageURI(pushEventUiModel.avatarUrl)
            textViewPushEventItemDisplayName.text = pushEventUiModel.displayName
            textViewPushEventItemDescription.text =
                view.context.getString(R.string.push_event_description, pushEventUiModel.ref)
            textViewPushEventItemCreationDate.text =
                pushEventUiModel.createdAt
            view.setOnClickListener { onClickListener.onClick(pushEventUiModel) }
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is PushEventItem && pushEventUiModel.id == newItem.pushEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is PushEventItem && pushEventUiModel == newItem.pushEventUiModel
}