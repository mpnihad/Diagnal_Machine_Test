package com.nihad.diagnal

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }



    companion object {
        @get:Synchronized
        var sInstance: MovieApplication? = null

    }

}