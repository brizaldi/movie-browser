package com.brizaldi.moviebrowser.models.network

import com.brizaldi.moviebrowser.models.NetworkResponseModel
import com.brizaldi.moviebrowser.models.Video

data class VideoListResponse(
    val id: Int,
    val results: List<Video>
) : NetworkResponseModel