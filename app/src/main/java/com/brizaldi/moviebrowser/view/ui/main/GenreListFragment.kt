package com.brizaldi.moviebrowser.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brizaldi.moviebrowser.R
import com.brizaldi.moviebrowser.compose.ViewModelFragment
import com.brizaldi.moviebrowser.databinding.MainFragmentGenreBinding
import com.brizaldi.moviebrowser.view.adapter.GenreListAdapter

class GenreListFragment : ViewModelFragment() {

    private val viewModel: MainActivityViewModel by injectActivityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<MainFragmentGenreBinding>(inflater, R.layout.main_fragment_genre, container)
            .apply {
                viewModel = this@GenreListFragment.viewModel.apply { postGenrePage(1) }
                lifecycleOwner = this@GenreListFragment
                adapter = GenreListAdapter()
            }.root
    }
}