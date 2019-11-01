package com.alex_zaitsev.weatherapp.data

import com.alex_zaitsev.weatherapp.data.api.CurrentWeatherResponse
import com.alex_zaitsev.weatherapp.data.api.WeatherApiManager
import kotlinx.coroutines.Deferred
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(val weatherApiManager: WeatherApiManager) {

    fun getCurrentWeather(city: String, appId: String): Deferred<Response<CurrentWeatherResponse>> {
        return weatherApiManager.getCurrentWeather(city, appId)
    }
}
