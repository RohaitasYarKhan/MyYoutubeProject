package com.rohaitas.myyotubeproject.application

import android.app.Application
import com.rohaitas.myyotubeproject.database.AppDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // we have initialized database in App class
        // App class must be in manifest as name of App
        AppDatabase.Companion.initDatabase(this)

    }
}