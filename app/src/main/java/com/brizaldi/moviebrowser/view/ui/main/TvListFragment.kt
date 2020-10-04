package com.brizaldi.moviebrowser.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brizaldi.moviebrowser.R
import com.brizaldi.moviebrowser.compose.ViewModelFragment
import com.brizaldi.moviebrowser.databinding.MainFragmentTvBinding
import com.brizaldi.moviebrowser.view.adapter.TvListAdapter

class TvListFragment : ViewModelFragment() {

    private val viewModel: MainActivityViewModel by injectActivityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<MainFragmentTvBinding>(inflater, R.layout.main_fragment_tv, container)
            .apply {
                viewModel = this@TvListFragment.viewModel.apply { postTvPage(1) }
                lifecycleOwner = this@TvListFragment
                adapter = TvListAdapter()
            }.root
    }
}