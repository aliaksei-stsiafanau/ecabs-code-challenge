package com.alexstephanov.ecabscodechallenge.presentation.eventdetails.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.SectionIssuesEventPayloadItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems.RecyclerItem
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.IssuesEventUiModel

class IssuesEventSectionItem(val issuesEventUiModel: IssuesEventUiModel) : RecyclerItem {
    override val viewId: Int = R.layout.section_issues_event_payload_item

    override fun bind(view: View) {
        with(SectionIssuesEventPayloadItemBinding.bind(view)) {
            textViewSectionIssuesEventPayloadItemEventTypeLabel.text = issuesEventUiModel.issueTitle
            chipIssuesEventPayloadItemAction.text = issuesEventUiModel.action
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is IssuesEventSectionItem && issuesEventUiModel.id == newItem.issuesEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is IssuesEventSectionItem && issuesEventUiModel == newItem.issuesEventUiModel
}