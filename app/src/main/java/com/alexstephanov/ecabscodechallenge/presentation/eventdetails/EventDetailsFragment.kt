package com.alexstephanov.ecabscodechallenge.presentation.eventdetails

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alexstephanov.ecabscodechallenge.App
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.FragmentEventDetailsBinding
import com.alexstephanov.ecabscodechallenge.presentation.RecyclerDataAdapter
import com.alexstephanov.ecabscodechallenge.presentation.uimodels.*
import com.alexstephanov.ecabscodechallenge.utils.ViewModelFactory
import com.alexstephanov.ecabscodechallenge.utils.viewBinding
import javax.inject.Inject

class EventDetailsFragment : Fragment(R.layout.fragment_event_details) {

    private val binding: FragmentEventDetailsBinding by viewBinding(FragmentEventDetailsBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EventDetailsViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerDataAdapter: RecyclerDataAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App).appComponent.eventDetailsSubcomponent().create().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val eventUiModel = arguments?.getParcelable<EventUiModel>(EVENT_DETAILS_FRAGMENT_TAG)
        val recyclerItem = viewModel.convertUiModelIntoRecyclerItem(eventUiModel!!)
        binding.recyclerViewEventDetailsList.adapter = recyclerDataAdapter
        recyclerDataAdapter.submitList(recyclerItem)
    }

    companion object {
        const val EVENT_DETAILS_FRAGMENT_TAG = "EVENT_DETAILS"
    }
}