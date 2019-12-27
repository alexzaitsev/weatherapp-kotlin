package com.alex_zaitsev.weatherapp.view

import com.alex_zaitsev.weatherapp.view.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel(get()) }
}