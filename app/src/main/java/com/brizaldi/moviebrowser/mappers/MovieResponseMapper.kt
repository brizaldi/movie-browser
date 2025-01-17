package com.brizaldi.moviebrowser.mappers

import com.brizaldi.moviebrowser.models.network.DiscoverMovieResponse
import timber.log.Timber

class MovieResponseMapper : NetworkResponseMapper<DiscoverMovieResponse> {
    override fun onLastPage(response: DiscoverMovieResponse): Boolean {
        Timber.d("loadPage : ${response.page}/${response.total_pages}")
        return response.page > response.total_pages
    }
}