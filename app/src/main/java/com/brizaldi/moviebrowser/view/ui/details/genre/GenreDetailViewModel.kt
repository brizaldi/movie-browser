package com.brizaldi.moviebrowser.view.ui.details.genre

import androidx.lifecycle.*
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.entity.Genre
import com.brizaldi.moviebrowser.models.entity.Movie
import com.brizaldi.moviebrowser.models.entity.Tv
import com.brizaldi.moviebrowser.repository.BrowseGenreRepository
import com.brizaldi.moviebrowser.utils.AbsentLiveData
import timber.log.Timber
import javax.inject.Inject

class GenreDetailActivityViewModel @Inject constructor(
    private val browseGenreRepository: BrowseGenreRepository
) : ViewModel() {

    private lateinit var genre: Genre

    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<Resource<List<Movie>>>

    private var tvPageLiveData: MutableLiveData<Int> = MutableLiveData()
    val tvListLiveData: LiveData<Resource<List<Tv>>>

    init {
        Timber.d("injection MainActivityViewModel")

        movieListLiveData = moviePageLiveData.switchMap {
            moviePageLiveData.value?.let {
                loadMovies(it)
            } ?: AbsentLiveData.create()
        }

        tvListLiveData = tvPageLiveData.switchMap {
            tvPageLiveData.value?.let {
                loadTvs(it)
            } ?: AbsentLiveData.create()
        }
    }

    fun setGenre(genre: Genre) {
        this.genre = genre
    }

    private fun loadMovies(page: Int): LiveData<Resource<List<Movie>>> {
        return if (genre == null)
            MediatorLiveData()
        else
            browseGenreRepository.loadMovies(page, genre.id.toString())
    }

    private fun loadTvs(page: Int): LiveData<Resource<List<Tv>>> {
        return if (genre == null)
            MediatorLiveData()
        else
            browseGenreRepository.loadTvs(page, genre.id.toString())
    }

    fun getMovieListValues() = movieListLiveData.value
    fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)

    fun getTvListValues() = tvListLiveData.value
    fun postTvPage(page: Int) = tvPageLiveData.postValue(page)
}