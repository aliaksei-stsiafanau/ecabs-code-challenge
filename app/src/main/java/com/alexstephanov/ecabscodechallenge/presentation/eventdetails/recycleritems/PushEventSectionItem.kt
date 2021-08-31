package com.alexstephanov.ecabscodechallenge.presentation.eventdetails.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.SectionPushEventPayloadItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.PushEventUiModel

class PushEventSectionItem(val pushEventUiModel: PushEventUiModel) : RecyclerItem {
    override val viewId: Int = R.layout.section_push_event_payload_item

    override fun bind(view: View) {
        with(SectionPushEventPayloadItemBinding.bind(view)) {
            textViewSectionPushEventPayloadItemInfo.text = pushEventUiModel.ref
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is PushEventSectionItem && pushEventUiModel.id == newItem.pushEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is PushEventSectionItem && pushEventUiModel == newItem.pushEventUiModel
}