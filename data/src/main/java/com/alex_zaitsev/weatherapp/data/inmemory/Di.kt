package com.alex_zaitsev.weatherapp.data.inmemory

import org.koin.dsl.module

val inMemoryModule = module {
    single { InMemoryManager() }
}
