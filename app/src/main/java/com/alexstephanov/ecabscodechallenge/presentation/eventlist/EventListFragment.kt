package com.alexstephanov.ecabscodechallenge.presentation.eventlist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.alexstephanov.ecabscodechallenge.App
import com.alexstephanov.ecabscodechallenge.R
import com.alexstephanov.ecabscodechallenge.databinding.FragmentEventListBinding
import com.alexstephanov.ecabscodechallenge.presentation.RecyclerDataAdapter
import com.alexstephanov.ecabscodechallenge.presentation.eventdetails.EventDetailsFragment
import com.alexstephanov.ecabscodechallenge.utils.ViewModelFactory
import com.alexstephanov.ecabscodechallenge.utils.viewBinding
import javax.inject.Inject

class EventListFragment : Fragment(R.layout.fragment_event_list) {

    private val binding: FragmentEventListBinding by viewBinding(FragmentEventListBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EventListViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerDataAdapter: RecyclerDataAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App).appComponent.eventListSubcomponent().create()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeData()
        observeClick()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    private fun observeData() {
        binding.progressBarEventListLoading.visibility = View.VISIBLE
        binding.recyclerViewEventsList.adapter = recyclerDataAdapter
        viewModel.eventsLiveData.observe(viewLifecycleOwner, { eventResponse ->
            binding.progressBarEventListLoading.visibility = View.GONE
            if(eventResponse.isSuccess) {
                with(binding) {
                    recyclerViewEventsList.visibility = View.VISIBLE
                    groupEventListError.visibility = View.GONE
                }
                recyclerDataAdapter.submitList(eventResponse.getOrDefault(emptyList()))
            } else if(eventResponse.isFailure) {
                with(binding) {
                    recyclerViewEventsList.visibility = View.GONE
                    groupEventListError.visibility = View.VISIBLE
                    buttonEventListErrorRetry.setOnClickListener { retry() }
                }
            }
        })
    }

    private fun observeClick() {
        viewModel.clickEvent.observe(viewLifecycleOwner, { eventUiModel ->
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container, EventDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(
                            EventDetailsFragment.EVENT_DETAILS_FRAGMENT_TAG,
                            eventUiModel
                        )
                    }
                })
                addToBackStack(null)
            }
        })
    }

    private fun retry() {
        with(binding) {
            progressBarEventListLoading.visibility = View.VISIBLE
            groupEventListError.visibility = View.GONE
        }
        viewModel.retry()
    }
}