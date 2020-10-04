package com.brizaldi.moviebrowser.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brizaldi.moviebrowser.R
import com.brizaldi.moviebrowser.compose.ViewModelFragment
import com.brizaldi.moviebrowser.databinding.MainFragmentMovieBinding
import com.brizaldi.moviebrowser.view.adapter.MovieListAdapter

class MovieListFragment : ViewModelFragment() {

    private val viewModel: MainActivityViewModel by injectActivityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<MainFragmentMovieBinding>(inflater, R.layout.main_fragment_movie, container)
            .apply {
                viewModel = this@MovieListFragment.viewModel.apply { postMoviePage(1) }
                lifecycleOwner = this@MovieListFragment
                adapter = MovieListAdapter()
            }.root
    }
}