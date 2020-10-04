package com.brizaldi.moviebrowser.mappers

import com.brizaldi.moviebrowser.models.network.GenreListResponse

class GenreResponseMapper : NetworkResponseMapper<GenreListResponse> {
    override fun onLastPage(response: GenreListResponse): Boolean {
        return true
    }
}