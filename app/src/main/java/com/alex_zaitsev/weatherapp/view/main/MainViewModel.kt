package com.alex_zaitsev.weatherapp.view.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.alex_zaitsev.weatherapp.R
import com.alex_zaitsev.weatherapp.domain.DomainError
import com.alex_zaitsev.weatherapp.domain.DomainResult
import com.alex_zaitsev.weatherapp.domain.usecases.GetCurrentWeatherUseCase
import com.alex_zaitsev.weatherapp.entity.models.CurrentWeather
import com.alex_zaitsev.weatherapp.view.BaseViewModel


class MainViewModel(
    private val currentWeatherUseCase: GetCurrentWeatherUseCase
) : BaseViewModel() {

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
    val currentWeather = MediatorLiveData<CurrentWeather>()

    init {
        currentWeather.addSource(inputCity) { city: String ->
            asyncRunIfConnected {
                when (val result = currentWeatherUseCase.get(city)) {
                    is DomainResult.Success -> {
                        isDataVisible.value = true
                        isErrorVisible.value = false
                        currentWeather.value = result.value
                    }
                    is DomainResult.Error -> {
                        isDataVisible.value = false
                        isErrorVisible.value = true
                        when (val error = result.error) {
                            is DomainError.NotFound -> _error.value = R.string.city_not_found
                            is DomainError.General -> errorMessage.value = error.message
                        }
                    }
                }
            }
        }
    }
}
