package com.brizaldi.moviebrowser.api

import androidx.lifecycle.LiveData
import com.brizaldi.moviebrowser.models.network.DiscoverMovieResponse
import com.brizaldi.moviebrowser.models.network.DiscoverTvResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BrowseGenreService {
    /**
     * https://developers.themoviedb.org/3/discover/movie-discover
     *  Discover movies.
     */
    @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
    fun fetchDiscoverMovie(
        @Query("page") page: Int,
        @Query("with_genres") genreId: String
    ): LiveData<ApiResponse<DiscoverMovieResponse>>

    /**
     * https://developers.themoviedb.org/3/discover/tv-discover
     *  Discover TV shows.
     */
    @GET("/3/discover/tv?language=en&sort_by=popularity.desc")
    fun fetchDiscoverTv(
        @Query("page") page: Int,
        @Query("with_genres") genreId: String
    ): LiveData<ApiResponse<DiscoverTvResponse>>
}