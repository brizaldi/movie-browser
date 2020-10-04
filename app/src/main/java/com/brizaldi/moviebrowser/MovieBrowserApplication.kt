package com.brizaldi.moviebrowser

import android.os.Build
import com.brizaldi.moviebrowser.di.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.DaggerApplication
import timber.log.Timber

class TheMoviesApplication : DaggerApplication() {

    private val appComponent = DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        if (!isRobolectricUnitTest()) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun isRobolectricUnitTest(): Boolean {
        return "robolectric" == Build.FINGERPRINT
    }

    override fun applicationInjector() = appComponent
}