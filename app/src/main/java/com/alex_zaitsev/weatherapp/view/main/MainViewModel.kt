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

    // ============================= INPUT ==============================
    /**
     * City name entered by user
     */
    val inputCity = MutableLiveData<String>()

    // ============================= OUTPUT =============================
    /**
     * Defines whether API request failed and error should be shown
     */
    val isErrorVisible = MutableLiveData<Boolean>()
    /**
     * Error message if API request failed
     */
    val errorMessage = MutableLiveData<String>()
    /**
     * Defines whether API request finished correctly and data is retrieved successfully
     */
    val isDataVisible = MutableLiveData<Boolean>()
    /**
     * Data that should be shown to the user if API request was successful
     */
    val currentWeather = MediatorLiveData<CurrentWeatherResult.Data>()

    val isProgressVisible = MutableLiveData<Boolean>()

    init {
        currentWeather.addSource(inputCity) { city: String ->
            isProgressVisible.value = true
            viewModelScope.launch {
                when(val result = currentWeatherUseCase.get(city)) {
                    is CurrentWeatherResult.Data -> {
                        isDataVisible.value = true
                        isErrorVisible.value = false
                        currentWeather.value = result
                    }
                    is CurrentWeatherResult.Error -> {
                        isDataVisible.value = false
                        isErrorVisible.value = true
                        errorMessage.value = result.message
                    }
                }
                isProgressVisible.value = false
            }
        }
    }
}
