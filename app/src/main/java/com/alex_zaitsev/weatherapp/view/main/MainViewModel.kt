package com.alex_zaitsev.weatherapp.view.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alex_zaitsev.weatherapp.domain.usecases.current_weather.GetCurrentWeatherUseCase


class MainViewModel : ViewModel() {

    private val getCurrentWeatherUseCase = GetCurrentWeatherUseCase()

    val currentCity = MutableLiveData<String>()
    val currentWeather = MediatorLiveData<String>()

    init {
        currentWeather.addSource(currentCity) { city: String ->
            currentWeather.value = getCurrentWeatherUseCase.get(city).toString()
        }
    }
}