package com.brizaldi.moviebrowser.models.network

import com.brizaldi.moviebrowser.models.NetworkResponseModel
import com.brizaldi.moviebrowser.models.entity.Tv

data class DiscoverTvResponse(
    val page: Int,
    val results: List<Tv>,
    val total_results: Int,
    val total_pages: Int
) : NetworkResponseModel