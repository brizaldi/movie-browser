package com.brizaldi.moviebrowser.repository

import androidx.lifecycle.LiveData
import com.brizaldi.moviebrowser.api.ApiResponse
import com.brizaldi.moviebrowser.api.GenreService
import com.brizaldi.moviebrowser.mappers.GenreResponseMapper
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.entity.Genre
import com.brizaldi.moviebrowser.models.network.GenreListResponse
import com.brizaldi.moviebrowser.room.GenreDao
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GenreRepository @Inject constructor(
    val genreService: GenreService,
    val genreDao: GenreDao
) : Repository {

    init {
        Timber.d("Injection GenreRepository")
    }

    fun loadGenres(): LiveData<Resource<List<Genre>>> {
        return object : NetworkBoundRepository<List<Genre>, GenreListResponse, GenreResponseMapper>() {
            override fun saveFetchData(items: GenreListResponse) {
                genreDao.insertGenreList(items.genres)
            }

            override fun shouldFetch(data: List<Genre>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Genre>> {
                return genreDao.getGenreList()
            }

            override fun fetchService(): LiveData<ApiResponse<GenreListResponse>> {
                return genreService.fetchGenres()
            }

            override fun mapper(): GenreResponseMapper {
                return GenreResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed : $message")
            }
        }.asLiveData()
    }
}