package com.alex_zaitsev.weatherapp.domain

import com.alex_zaitsev.weatherapp.domain.usecases.GetCurrentWeatherUseCase
import org.koin.dsl.module

val useCasesModule = module {

    single {
        GetCurrentWeatherUseCase(
            get()
        )
    }
}
