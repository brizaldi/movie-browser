package com.brizaldi.moviebrowser.di

import com.brizaldi.moviebrowser.compose.ViewModelActivity
import com.brizaldi.moviebrowser.compose.ViewModelFragment
import com.brizaldi.moviebrowser.di.annotations.ActivityScope
import com.brizaldi.moviebrowser.di.annotations.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ComposeModule {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeViewModelActivity(): ViewModelActivity

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeViewModelFragment(): ViewModelFragment
}