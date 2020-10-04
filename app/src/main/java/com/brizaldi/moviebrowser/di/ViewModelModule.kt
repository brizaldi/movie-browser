package com.brizaldi.moviebrowser.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brizaldi.moviebrowser.di.annotations.ViewModelKey
import com.brizaldi.moviebrowser.view.ui.details.genre.GenreDetailActivityViewModel
import com.brizaldi.moviebrowser.view.ui.details.movie.MovieDetailViewModel
import com.brizaldi.moviebrowser.view.ui.details.tv.TvDetailViewModel
import com.brizaldi.moviebrowser.view.ui.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModels(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GenreDetailActivityViewModel::class)
    internal abstract fun bindGenreDetailActivityViewModels(genreDetailActivityViewModel: GenreDetailActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    internal abstract fun bindMovieDetailViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvDetailViewModel::class)
    internal abstract fun bindTvDetailViewModel(tvDetailViewModel: TvDetailViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}