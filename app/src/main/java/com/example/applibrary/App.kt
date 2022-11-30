package com.example.applibrary

import android.app.Application
import com.example.applibrary.id.dataSourceModule
import com.example.applibrary.id.repoModule
import com.example.applibrary.id.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(repoModule, viewModelModule, dataSourceModule))
        }
    }
}