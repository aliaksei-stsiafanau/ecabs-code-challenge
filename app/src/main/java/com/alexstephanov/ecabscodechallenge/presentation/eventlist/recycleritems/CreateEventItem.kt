package com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.CreateEventItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.OnClickListener
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.CreateEventUiModel
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel

class CreateEventItem(
    val createEventUiModel: CreateEventUiModel,
    private val onClickListener: OnClickListener<EventUiModel>
) : RecyclerItem {

    override val viewId: Int = R.layout.create_event_item

    override fun bind(view: View) {
        with(CreateEventItemBinding.bind(view)) {
            draweeViewCreateEventItemUserLogo.setImageURI(createEventUiModel.avatarUrl)
            textViewCreateEventItemDisplayName.text = createEventUiModel.displayName
            val ref = createEventUiModel.ref ?: view.context.getString(R.string.unknown_field_value)
            textViewCreateEventItemDescription.text = view.context.getString(
                R.string.create_event_description,
                createEventUiModel.refType,
                ref
            )
            textViewCreateEventItemCreationDate.text =
                createEventUiModel.createdAt
            view.setOnClickListener {
                onClickListener.onClick(createEventUiModel)
            }
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is CreateEventItem && createEventUiModel.id == newItem.createEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is CreateEventItem && createEventUiModel == newItem.createEventUiModel
}