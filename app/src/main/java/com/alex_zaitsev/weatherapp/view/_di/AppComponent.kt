package com.alex_zaitsev.weatherapp.view._di

import com.alex_zaitsev.weatherapp.view.App
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class])
@Singleton
interface AppComponent {

    fun inject(app: App)
}
