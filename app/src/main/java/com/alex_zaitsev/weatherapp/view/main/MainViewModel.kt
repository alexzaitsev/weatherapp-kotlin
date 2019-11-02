package com.alex_zaitsev.weatherapp.view.main

import androidx.lifecycle.*
import com.alex_zaitsev.weatherapp.domain.usecases.current_weather.GetCurrentWeatherUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel
    @Inject constructor(val currentWeatherUseCase: GetCurrentWeatherUseCase)
    : ViewModel() {

    val currentCity = MutableLiveData<String>()
    val currentWeather = MediatorLiveData<String>()

    init {
        currentWeather.addSource(currentCity) { city: String ->
            viewModelScope.launch {
                val currentWeatherStr = currentWeatherUseCase.get(city).toString()
                currentWeather.value = currentWeatherStr
            }
        }
    }
}
