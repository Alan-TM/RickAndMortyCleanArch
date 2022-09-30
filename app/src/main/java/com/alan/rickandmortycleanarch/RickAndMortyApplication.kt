package com.alan.rickandmortycleanarch

import android.app.Application
import com.alan.rickandmortycleanarch.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyApplication)
            loadKoinModules(appModule)
        }
    }
}