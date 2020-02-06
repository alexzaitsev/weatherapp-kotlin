package com.alex_zaitsev.weatherapp.domain

import com.alex_zaitsev.weatherapp.domain.operations.SettingsOperations
import com.alex_zaitsev.weatherapp.domain.operations.WeatherOperations
import org.koin.dsl.module

val domainModule = module {
    single { WeatherOperations(get(), get()) }
    single { SettingsOperations(get()) }
}
