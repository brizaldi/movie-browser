package com.brizaldi.moviebrowser.di

import com.brizaldi.moviebrowser.di.annotations.FragmentScope
import com.brizaldi.moviebrowser.view.ui.details.genre.MovieListFragment
import com.brizaldi.moviebrowser.view.ui.details.genre.TvListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GenreDetailActivityFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeTvListFragment(): TvListFragment
}