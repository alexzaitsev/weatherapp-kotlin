package com.alex_zaitsev.weatherapp.data

import org.koin.dsl.module

val repositoryModule = module {
    single { DataRepository(get()) }
}
