package com.alexstephanov.ecabscodechallenge.presentation.eventdetails.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.SectionCommonDetailsItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel

class CommonSectionItem(val eventUiModel: EventUiModel) : RecyclerItem {
    override val viewId: Int = R.layout.section_common_details_item

    override fun bind(view: View) {
        with(SectionCommonDetailsItemBinding.bind(view)) {
            draweeViewSectionCommonDetailsItemAvatar.setImageURI(eventUiModel.avatarUrl)
            textViewSectionCommonDetailsItemUserLogins.text = view.context.getString(
                R.string.common_section_logins,
                eventUiModel.displayName,
                eventUiModel.login
            )
            textViewSectionCommonDetailsItemRepositoryDescription.text = view.context.getString(
                R.string.repository_label,
                eventUiModel.repoName
            )
            textViewSectionCommonDetailsItemCreatedAt.text = eventUiModel.createdAt
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is CommonSectionItem && eventUiModel.id == newItem.eventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is CommonSectionItem && eventUiModel == newItem.eventUiModel
}