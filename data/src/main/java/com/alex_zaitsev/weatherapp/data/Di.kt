package com.alex_zaitsev.weatherapp.data

import org.koin.dsl.module

val dataModule = module {
    single { DataRepository(get()) }
}
