package com.alex_zaitsev.weatherapp.view

import android.app.Application
import com.alex_zaitsev.weatherapp.data.api.apiModule
import com.alex_zaitsev.weatherapp.data.dataModule
import com.alex_zaitsev.weatherapp.domain.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    domainModule,
                    dataModule,
                    apiModule
                )
            )
        }
    }
}
