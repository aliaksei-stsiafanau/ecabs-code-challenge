package com.alexstephanov.ecabscodechallenge.presentation.eventdetails.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.SectionCreateEventPayloadItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.CreateEventUiModel

class CreateEventSectionItem(val createEventUiModel: CreateEventUiModel) : RecyclerItem {
    override val viewId: Int = R.layout.section_create_event_payload_item

    override fun bind(view: View) {
        with(SectionCreateEventPayloadItemBinding.bind(view)) {
            val ref = createEventUiModel.ref ?: view.context.getString(R.string.unknown_field_value)
            textViewSectionCreateEventPayloadItemInfo.text = view.context.getString(
                R.string.create_event_description,
                createEventUiModel.refType,
                ref
            )
            val description = createEventUiModel.description ?: view.context.getString(R.string.unknown_field_value)
            textViewSectionCreateEventPayloadItemDescription.text = description
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is CreateEventSectionItem && createEventUiModel.id == newItem.createEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is CreateEventSectionItem && createEventUiModel == newItem.createEventUiModel
}