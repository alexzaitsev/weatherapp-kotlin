package com.alex_zaitsev.weatherapp.view.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex_zaitsev.weatherapp.domain.usecases.current_weather.CurrentWeatherResult
import com.alex_zaitsev.weatherapp.domain.usecases.current_weather.GetCurrentWeatherUseCase
import kotlinx.coroutines.launch


class MainViewModel constructor(private val currentWeatherUseCase: GetCurrentWeatherUseCase) :
    ViewModel() {

    val currentCity = MutableLiveData<String>()
    val currentWeather = MediatorLiveData<String>()

    init {
        currentWeather.addSource(currentCity) { city: String ->
            viewModelScope.launch {
                when(val result = currentWeatherUseCase.get(city)) {
                    is CurrentWeatherResult.Data -> currentWeather.value = result.toString()
                    is CurrentWeatherResult.Error -> currentWeather.value = result.message
                }
            }
        }
    }
}
