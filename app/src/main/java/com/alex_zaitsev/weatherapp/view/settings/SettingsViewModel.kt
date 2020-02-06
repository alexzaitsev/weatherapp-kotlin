package com.alex_zaitsev.weatherapp.view.settings

import androidx.lifecycle.MutableLiveData
import com.alex_zaitsev.weatherapp.domain.operations.WeatherOperations
import com.alex_zaitsev.weatherapp.view.BaseViewModel

class SettingsViewModel(
    private val weatherOperations: WeatherOperations
) : BaseViewModel() {

    val inputCity = MutableLiveData<String>()

    fun loadData() {

    }

    fun loadWeather(city: String) {
//        asyncRunIfConnected {
//            when (val result = currentWeatherUseCase.get(city)) {
//                is DomainResult.Success -> _data.value = result.value
//                is DomainResult.Error -> {
//                    _isStubVisible.value = true
//                    _error.value = when (val error = result.error) {
//                        is DomainError.NotFound -> UiError.Resource(R.string.city_not_found)
//                        is DomainError.General -> UiError.Message(error.message)
//                    }
//                }
//            }
//        }
    }
}
