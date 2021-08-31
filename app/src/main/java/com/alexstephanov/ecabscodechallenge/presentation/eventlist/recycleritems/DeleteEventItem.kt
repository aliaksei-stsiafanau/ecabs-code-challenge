package com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.DeleteEventItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.OnClickListener
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.DeleteEventUiModel
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel

class DeleteEventItem(
    val deleteEventUiModel: DeleteEventUiModel,
    private val onClickListener: OnClickListener<EventUiModel>
) : RecyclerItem {

    override val viewId: Int = R.layout.delete_event_item

    override fun bind(view: View) {
        with(DeleteEventItemBinding.bind(view)) {
            draweeViewDeleteEventItemUserLogo.setImageURI(deleteEventUiModel.avatarUrl)
            textViewDeleteEventItemDisplayName.text = deleteEventUiModel.displayName
            textViewDeleteEventItemDescription.text = view.context.getString(
                R.string.delete_event_description,
                deleteEventUiModel.refType,
                deleteEventUiModel.ref
            )
            textViewDeleteEventItemCreationDate.text =
                deleteEventUiModel.createdAt
            view.setOnClickListener { onClickListener.onClick(deleteEventUiModel) }
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is DeleteEventItem && deleteEventUiModel.id == newItem.deleteEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is DeleteEventItem && deleteEventUiModel == newItem.deleteEventUiModel
}