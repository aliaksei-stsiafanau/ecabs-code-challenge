package com.alexstephanov.ecabscodechallenge.presentation.eventlist.recycleritems

import android.view.View
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.IssuesEventItemBinding
import com.alexstephanov.ecabscodechallenge.presentation.OnClickListener
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.EventUiModel
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.IssuesEventUiModel

class IssuesEventItem(
    val issuesEventUiModel: IssuesEventUiModel,
    private val onClickListener: OnClickListener<EventUiModel>
) : RecyclerItem {

    override val viewId: Int = R.layout.issues_event_item

    override fun bind(view: View) {
        with(IssuesEventItemBinding.bind(view)) {
            draweeViewIssuesEventItemUserLogo.setImageURI(issuesEventUiModel.avatarUrl)
            textViewIssuesEventItemDisplayName.text = issuesEventUiModel.displayName
            chipIssuesEventItemStatus.text = issuesEventUiModel.action
            textViewIssuesEventItemDescription.text = issuesEventUiModel.issueTitle
            textViewIssuesEventItemCreationDate.text =
                issuesEventUiModel.createdAt
            view.setOnClickListener { onClickListener.onClick(issuesEventUiModel) }
        }
    }

    override fun areItemsTheSame(newItem: RecyclerItem): Boolean =
        newItem is IssuesEventItem && issuesEventUiModel.id == newItem.issuesEventUiModel.id

    override fun areContentsTheSame(newItem: RecyclerItem): Boolean =
        newItem is IssuesEventItem && issuesEventUiModel == newItem.issuesEventUiModel
}