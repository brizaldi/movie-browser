package com.brizaldi.moviebrowser.models.network

import com.brizaldi.moviebrowser.models.NetworkResponseModel
import com.brizaldi.moviebrowser.models.entity.Genre

data class GenreListResponse(
    val genres: List<Genre>
) : NetworkResponseModel