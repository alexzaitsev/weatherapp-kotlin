package com.alex_zaitsev.weatherapp.data

import com.alex_zaitsev.weatherapp.data.repositories.CityRepository
import com.alex_zaitsev.weatherapp.data.repositories.WeatherRepository
import org.koin.dsl.module

val dataModule = module {
    single { WeatherRepository(get()) }
    single { CityRepository(get()) }
}
