package com.alex_zaitsev.weatherapp.view._di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context {
        return appContext
    }
}
