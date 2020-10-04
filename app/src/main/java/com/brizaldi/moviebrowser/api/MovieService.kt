package com.brizaldi.moviebrowser.api

import androidx.lifecycle.LiveData
import com.brizaldi.moviebrowser.models.network.KeywordListResponse
import com.brizaldi.moviebrowser.models.network.ReviewListResponse
import com.brizaldi.moviebrowser.models.network.VideoListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    /**
     * https://developers.themoviedb.org/3/movies/get-movie-keywords
     * Get the keywords from a movie.
     */
    @GET("/3/movie/{movie_id}/keywords")
    fun fetchKeywords(@Path("movie_id") id: Int): LiveData<ApiResponse<KeywordListResponse>>

    /**
     * https://developers.themoviedb.org/3/movies/get-movie-videos
     * Get the videos from a movie.
     */
    @GET("/3/movie/{movie_id}/videos")
    fun fetchVideos(@Path("movie_id") id: Int): LiveData<ApiResponse<VideoListResponse>>

    /**
     * https://developers.themoviedb.org/3/movies/get-movie-reviews
     * Get the user reviews.
     */
    @GET("/3/movie/{movie_id}/reviews")
    fun fetchReviews(@Path("movie_id") id: Int): LiveData<ApiResponse<ReviewListResponse>>
}