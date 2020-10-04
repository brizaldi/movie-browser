package com.brizaldi.moviebrowser.models.network

import com.brizaldi.moviebrowser.models.NetworkResponseModel
import com.brizaldi.moviebrowser.models.Review

class ReviewListResponse(
    val id: Int,
    val page: Int,
    val results: List<Review>,
    val total_pages: Int,
    val total_results: Int
) : NetworkResponseModel