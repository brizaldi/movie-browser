package com.brizaldi.moviebrowser.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brizaldi.moviebrowser.api.ApiResponse
import com.brizaldi.moviebrowser.api.MovieService
import com.brizaldi.moviebrowser.mappers.KeywordResponseMapper
import com.brizaldi.moviebrowser.mappers.ReviewResponseMapper
import com.brizaldi.moviebrowser.mappers.VideoResponseMapper
import com.brizaldi.moviebrowser.models.Keyword
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.Review
import com.brizaldi.moviebrowser.models.Video
import com.brizaldi.moviebrowser.models.network.KeywordListResponse
import com.brizaldi.moviebrowser.models.network.ReviewListResponse
import com.brizaldi.moviebrowser.models.network.VideoListResponse
import com.brizaldi.moviebrowser.room.MovieDao
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    val service: MovieService,
    val movieDao: MovieDao
) : Repository {

    init {
        Timber.d("Injection MovieRepository")
    }

    fun loadKeywordList(id: Int): LiveData<Resource<List<Keyword>>> {
        return object : NetworkBoundRepository<List<Keyword>, KeywordListResponse, KeywordResponseMapper>() {
            override fun saveFetchData(items: KeywordListResponse) {
                val movie = movieDao.getMovie(id_ = id)
                movie.keywords = items.keywords
                movieDao.updateMovie(movie = movie)
            }

            override fun shouldFetch(data: List<Keyword>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Keyword>> {
                val movie = movieDao.getMovie(id_ = id)
                val data: MutableLiveData<List<Keyword>> = MutableLiveData()
                data.postValue(movie.keywords)
                return data
            }

            override fun fetchService(): LiveData<ApiResponse<KeywordListResponse>> {
                return service.fetchKeywords(id = id)
            }

            override fun mapper(): KeywordResponseMapper {
                return KeywordResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed : $message")
            }
        }.asLiveData()
    }

    fun loadVideoList(id: Int): LiveData<Resource<List<Video>>> {
        return object : NetworkBoundRepository<List<Video>, VideoListResponse, VideoResponseMapper>() {
            override fun saveFetchData(items: VideoListResponse) {
                val movie = movieDao.getMovie(id_ = id)
                movie.videos = items.results
                movieDao.updateMovie(movie = movie)
            }

            override fun shouldFetch(data: List<Video>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Video>> {
                val movie = movieDao.getMovie(id_ = id)
                val data: MutableLiveData<List<Video>> = MutableLiveData()
                data.postValue(movie.videos)
                return data
            }

            override fun fetchService(): LiveData<ApiResponse<VideoListResponse>> {
                return service.fetchVideos(id = id)
            }

            override fun mapper(): VideoResponseMapper {
                return VideoResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed : $message")
            }
        }.asLiveData()
    }

    fun loadReviewsList(id: Int): LiveData<Resource<List<Review>>> {
        return object : NetworkBoundRepository<List<Review>, ReviewListResponse, ReviewResponseMapper>() {
            override fun saveFetchData(items: ReviewListResponse) {
                val movie = movieDao.getMovie(id_ = id)
                movie.reviews = items.results
                movieDao.updateMovie(movie = movie)
            }

            override fun shouldFetch(data: List<Review>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Review>> {
                val movie = movieDao.getMovie(id_ = id)
                val data: MutableLiveData<List<Review>> = MutableLiveData()
                data.postValue(movie.reviews)
                return data
            }

            override fun fetchService(): LiveData<ApiResponse<ReviewListResponse>> {
                return service.fetchReviews(id = id)
            }

            override fun mapper(): ReviewResponseMapper {
                return ReviewResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed : $message")
            }
        }.asLiveData()
    }
}