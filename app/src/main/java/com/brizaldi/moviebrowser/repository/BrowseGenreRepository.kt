package com.brizaldi.moviebrowser.repository

import androidx.lifecycle.LiveData
import com.brizaldi.moviebrowser.api.ApiResponse
import com.brizaldi.moviebrowser.api.BrowseGenreService
import com.brizaldi.moviebrowser.mappers.MovieResponseMapper
import com.brizaldi.moviebrowser.mappers.TvResponseMapper
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.entity.Movie
import com.brizaldi.moviebrowser.models.entity.Tv
import com.brizaldi.moviebrowser.models.network.DiscoverMovieResponse
import com.brizaldi.moviebrowser.models.network.DiscoverTvResponse
import com.brizaldi.moviebrowser.room.MovieDao
import com.brizaldi.moviebrowser.room.TvDao
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BrowseGenreRepository @Inject constructor(
    val browseGenreService: BrowseGenreService,
    val movieDao: MovieDao,
    val tvDao: TvDao
) : Repository {

    init {
        Timber.d("Injection DiscoverRepository")
    }

    fun nukeTable() {
        movieDao.nukeTable()
        tvDao.nukeTable()
    }

    fun loadMovies(page: Int, genreId: String): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundRepository<List<Movie>, DiscoverMovieResponse, MovieResponseMapper>() {
            override fun saveFetchData(items: DiscoverMovieResponse) {
                if (page == 1)
                    movieDao.nukeTable()
                for (item in items.results) {
                    item.page = page
                }
                movieDao.insertMovieList(movies = items.results)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<List<Movie>> {
                return movieDao.getMovieList(page_ = page)
            }

            override fun fetchService(): LiveData<ApiResponse<DiscoverMovieResponse>> {
                return browseGenreService.fetchDiscoverMovie(page = page, genreId = genreId)
            }

            override fun mapper(): MovieResponseMapper {
                return MovieResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed $message")
            }
        }.asLiveData()
    }

    fun loadTvs(page: Int, genreId: String): LiveData<Resource<List<Tv>>> {
        return object : NetworkBoundRepository<List<Tv>, DiscoverTvResponse, TvResponseMapper>() {
            override fun saveFetchData(items: DiscoverTvResponse) {
                if (page == 1)
                    tvDao.nukeTable()
                for (item in items.results) {
                    item.page = page
                }
                tvDao.insertTv(tvs = items.results)
            }

            override fun shouldFetch(data: List<Tv>?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<List<Tv>> {
                return tvDao.getTvList(page_ = page)
            }

            override fun fetchService(): LiveData<ApiResponse<DiscoverTvResponse>> {
                return browseGenreService.fetchDiscoverTv(page = page, genreId = genreId)
            }

            override fun mapper(): TvResponseMapper {
                return TvResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("oFetchFailed $message")
            }
        }.asLiveData()
    }
}