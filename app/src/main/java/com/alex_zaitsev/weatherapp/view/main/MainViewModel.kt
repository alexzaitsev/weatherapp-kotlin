package com.alex_zaitsev.weatherapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.alex_zaitsev.weatherapp.domain.operations.WeatherOperations
import com.alex_zaitsev.weatherapp.entity.models.CurrentWeather
import com.alex_zaitsev.weatherapp.view.BaseViewModel
import com.alex_zaitsev.weatherapp.view.utils.livedata.SingleLiveEvent


class MainViewModel(
    private val weatherOperations: WeatherOperations
) : BaseViewModel() {

    private val _isStubVisible = SingleLiveEvent<Boolean>()
    val isStubVisible: LiveData<Boolean>
        get() = _isStubVisible

    private val _isDataVisible = MediatorLiveData<Boolean>()
    val isDataVisible: LiveData<Boolean>
        get() = _isDataVisible

    private val _data = SingleLiveEvent<CurrentWeather>()
    val data: LiveData<CurrentWeather>
        get() = _data

    init {
        _isDataVisible.addSource(_isStubVisible) {
            _isDataVisible.value = !it
        }
    }

    fun loadData() {
        asyncRunIfConnected {
            _isStubVisible.value = true
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
        }
    }
}
