package com.brizaldi.moviebrowser.mappers

import com.brizaldi.moviebrowser.models.network.KeywordListResponse

class KeywordResponseMapper : NetworkResponseMapper<KeywordListResponse> {
    override fun onLastPage(response: KeywordListResponse): Boolean {
        return true
    }
}