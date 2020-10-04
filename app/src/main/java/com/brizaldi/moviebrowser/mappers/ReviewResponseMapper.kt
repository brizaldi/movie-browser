package com.brizaldi.moviebrowser.mappers

import com.brizaldi.moviebrowser.models.network.ReviewListResponse

class ReviewResponseMapper : NetworkResponseMapper<ReviewListResponse> {
    override fun onLastPage(response: ReviewListResponse): Boolean {
        return true
    }
}