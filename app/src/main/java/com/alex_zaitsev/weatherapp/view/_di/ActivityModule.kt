package com.alex_zaitsev.weatherapp.view._di

import com.alex_zaitsev.weatherapp.view._di.activity.ActivityMainModule
import com.alex_zaitsev.weatherapp.view.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [ActivityMainModule::class])
    abstract fun contributeMainActivity(): MainActivity

}
