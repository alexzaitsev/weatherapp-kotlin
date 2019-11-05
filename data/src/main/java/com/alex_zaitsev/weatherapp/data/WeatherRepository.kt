package com.alex_zaitsev.weatherapp.data

import com.alex_zaitsev.weatherapp.data.api.WeatherApiManager
import com.alex_zaitsev.weatherapp.data.api.response.CurrentWeatherResponse
import retrofit2.Response

class WeatherRepository constructor(private val weatherApiManager: WeatherApiManager) {

    suspend fun getCurrentWeather(city: String, appId: String): Response<CurrentWeatherResponse> {
        return weatherApiManager.getCurrentWeather(city, appId)
    }
}
