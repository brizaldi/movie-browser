package com.brizaldi.moviebrowser.di

import com.brizaldi.moviebrowser.di.annotations.ActivityScope
import com.brizaldi.moviebrowser.view.ui.details.genre.GenreDetailActivity
import com.brizaldi.moviebrowser.view.ui.details.movie.MovieDetailActivity
import com.brizaldi.moviebrowser.view.ui.details.tv.TvDetailActivity
import com.brizaldi.moviebrowser.view.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [GenreDetailActivityFragmentModule::class])
    internal abstract fun contributeGenreActivity(): GenreDetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeMovieDetailActivity(): MovieDetailActivity

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeTvDetailActivity(): TvDetailActivity
}