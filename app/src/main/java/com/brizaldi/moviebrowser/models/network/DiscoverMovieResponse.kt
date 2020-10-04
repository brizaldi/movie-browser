package com.brizaldi.moviebrowser.models.network

import com.brizaldi.moviebrowser.models.NetworkResponseModel
import com.brizaldi.moviebrowser.models.entity.Movie

data class DiscoverMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
) : NetworkResponseModel