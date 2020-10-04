package com.brizaldi.moviebrowser.di

import com.brizaldi.moviebrowser.di.annotations.FragmentScope
import com.brizaldi.moviebrowser.view.ui.main.GenreListFragment
import com.brizaldi.moviebrowser.view.ui.main.MovieListFragment
import com.brizaldi.moviebrowser.view.ui.main.TvListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeTvListFragment(): TvListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeGenreListFragment(): GenreListFragment
}