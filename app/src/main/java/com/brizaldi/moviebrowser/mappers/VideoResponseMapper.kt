package com.brizaldi.moviebrowser.mappers

import com.brizaldi.moviebrowser.models.network.VideoListResponse

class VideoResponseMapper : NetworkResponseMapper<VideoListResponse> {
    override fun onLastPage(response: VideoListResponse): Boolean {
        return true
    }
}