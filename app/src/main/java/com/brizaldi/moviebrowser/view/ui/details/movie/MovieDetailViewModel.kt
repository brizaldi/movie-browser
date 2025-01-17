package com.brizaldi.moviebrowser.view.ui.details.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.brizaldi.moviebrowser.models.Keyword
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.Review
import com.brizaldi.moviebrowser.models.Video
import com.brizaldi.moviebrowser.repository.MovieRepository
import com.brizaldi.moviebrowser.utils.AbsentLiveData
import timber.log.Timber
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val movieIdLiveData: MutableLiveData<Int> = MutableLiveData()
    val keywordListLiveData: LiveData<Resource<List<Keyword>>>
    val videoListLiveData: LiveData<Resource<List<Video>>>
    val reviewListLiveData: LiveData<Resource<List<Review>>>

    init {
        Timber.d("Injection MovieDetailViewModel")

        this.keywordListLiveData = movieIdLiveData.switchMap {
            movieIdLiveData.value?.let {
                repository.loadKeywordList(it)
            } ?: AbsentLiveData.create()
        }

        this.videoListLiveData = movieIdLiveData.switchMap {
            movieIdLiveData.value?.let {
                repository.loadVideoList(it)
            } ?: AbsentLiveData.create()
        }

        this.reviewListLiveData = movieIdLiveData.switchMap {
            movieIdLiveData.value?.let {
                repository.loadReviewsList(it)
            } ?: AbsentLiveData.create()
        }
    }

    fun postMovieId(id: Int) = movieIdLiveData.postValue(id)
}