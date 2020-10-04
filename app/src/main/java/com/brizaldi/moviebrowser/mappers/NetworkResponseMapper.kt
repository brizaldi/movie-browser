package com.brizaldi.moviebrowser.mappers

import com.brizaldi.moviebrowser.models.NetworkResponseModel

interface NetworkResponseMapper<in FROM : NetworkResponseModel> {
    fun onLastPage(response: FROM): Boolean
}