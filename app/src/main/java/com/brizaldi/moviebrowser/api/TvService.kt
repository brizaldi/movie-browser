package com.brizaldi.moviebrowser.api

import androidx.lifecycle.LiveData
import com.brizaldi.moviebrowser.models.network.KeywordListResponse
import com.brizaldi.moviebrowser.models.network.ReviewListResponse
import com.brizaldi.moviebrowser.models.network.VideoListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TvService {
    /**
     * https://developers.themoviedb.org/3/tv/get-tv-keywords
     * Get the keywords for a TV show.
     */
    @GET("/3/tv/{tv_id}/keywords")
    fun fetchKeywords(@Path("tv_id") id: Int): LiveData<ApiResponse<KeywordListResponse>>

    /**
     * https://developers.themoviedb.org/3/tv/get-tv-videos
     * Get the videos for a TV show.
     */
    @GET("/3/tv/{tv_id}/videos")
    fun fetchVideos(@Path("tv_id") id: Int): LiveData<ApiResponse<VideoListResponse>>

    /**
     * https://developers.themoviedb.org/3/tv/get-tv-reviews
     * Get the reviews for a TV show.
     */
    @GET("/3/tv/{tv_id}/reviews")
    fun fetchReviews(@Path("tv_id") id: Int): LiveData<ApiResponse<ReviewListResponse>>
}