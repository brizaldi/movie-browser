package com.brizaldi.moviebrowser.api

import androidx.lifecycle.LiveData
import com.brizaldi.moviebrowser.models.network.GenreListResponse
import retrofit2.http.GET

interface GenreService {
    /**
     * https://developers.themoviedb.org/3/genre/movie/list
     * Get the list of genres.
     */
    @GET("/3/genre/movie/list")
    fun fetchGenres(): LiveData<ApiResponse<GenreListResponse>>
}