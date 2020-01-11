package com.alex_zaitsev.weatherapp.domain

import com.alex_zaitsev.weatherapp.domain.operations.CityOperations
import com.alex_zaitsev.weatherapp.domain.operations.WeatherOperations
import org.koin.dsl.module

val domainModule = module {
    single { CityOperations(get(), get()) }
    single { WeatherOperations(get()) }
}
