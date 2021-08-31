package com.alexstephanov.ecabscodechallenge.presentation.eventdetails.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.SectionDeleteEventPayloadItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.DeleteEventUiModel

class DeleteEventSectionItem(val deleteEventUiModel: DeleteEventUiModel) : RecyclerItem {
    override val viewId: Int = R.layout.section_delete_event_payload_item

    override fun bind(view: View) {
        with(SectionDeleteEventPayloadItemBinding.bind(view)) {
            textViewSectionDeleteEventPayloadItemInfo.text = view.context.getString(
                R.string.delete_event_description,
                deleteEventUiModel.refType,
                deleteEventUiModel.ref
            )
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is DeleteEventSectionItem && deleteEventUiModel.id == newItem.deleteEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is DeleteEventSectionItem && deleteEventUiModel == newItem.deleteEventUiModel
}