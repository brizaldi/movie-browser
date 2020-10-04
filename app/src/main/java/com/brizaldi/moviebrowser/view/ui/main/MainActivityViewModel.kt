package com.brizaldi.moviebrowser.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.entity.Genre
import com.brizaldi.moviebrowser.models.entity.Movie
import com.brizaldi.moviebrowser.models.entity.Tv
import com.brizaldi.moviebrowser.repository.DiscoverRepository
import com.brizaldi.moviebrowser.repository.GenreRepository
import com.brizaldi.moviebrowser.utils.AbsentLiveData
import timber.log.Timber
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val discoverRepository: DiscoverRepository,
    private val genreRepository: GenreRepository
) : ViewModel() {

    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<Resource<List<Movie>>>

    private var tvPageLiveData: MutableLiveData<Int> = MutableLiveData()
    val tvListLiveData: LiveData<Resource<List<Tv>>>

    private var genrePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val genreListLiveData: LiveData<Resource<List<Genre>>>

    init {
        Timber.d("injection MainActivityViewModel")

        movieListLiveData = moviePageLiveData.switchMap {
            moviePageLiveData.value?.let { discoverRepository.loadMovies(it) }
                ?: AbsentLiveData.create()
        }

        tvListLiveData = tvPageLiveData.switchMap {
            tvPageLiveData.value?.let { discoverRepository.loadTvs(it) } ?: AbsentLiveData.create()
        }

        genreListLiveData = genrePageLiveData.switchMap {
            genrePageLiveData.value?.let { genreRepository.loadGenres() }
                ?: AbsentLiveData.create()
        }

        genreRepository.loadGenres()
    }

    fun getMovieListValues() = movieListLiveData.value
    fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)

    fun getTvListValues() = tvListLiveData.value
    fun postTvPage(page: Int) = tvPageLiveData.postValue(page)

    fun getGenreListValues() = genreListLiveData.value
    fun postGenrePage(page: Int) = genrePageLiveData.postValue(page)
}