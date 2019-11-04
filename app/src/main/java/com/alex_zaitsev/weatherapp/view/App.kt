package com.alex_zaitsev.weatherapp.view

import android.app.Application
import com.alex_zaitsev.weatherapp.data.apiModule
import com.alex_zaitsev.weatherapp.data.repositoryModule
import com.alex_zaitsev.weatherapp.domain.usecases.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(
                appModule, useCasesModule,
                apiModule,
                repositoryModule
            ))
        }
    }
}
