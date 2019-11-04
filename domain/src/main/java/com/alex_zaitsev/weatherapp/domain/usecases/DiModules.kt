package com.alex_zaitsev.weatherapp.domain.usecases

import com.alex_zaitsev.weatherapp.domain.usecases.current_weather.GetCurrentWeatherUseCase
import org.koin.dsl.module

val useCasesModule = module {

    single { GetCurrentWeatherUseCase(get()) }
}