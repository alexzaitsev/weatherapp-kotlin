package com.alex_zaitsev.weatherapp.data


import com.alex_zaitsev.weatherapp.data.api.CurrentWeatherResponse
import com.alex_zaitsev.weatherapp.data.api.WeatherApiManager
import retrofit2.Response

class WeatherRepository(private val weatherApiManager: WeatherApiManager) {

    suspend fun getCurrentWeather(city: String): Response<CurrentWeatherResponse> {
        return weatherApiManager.getCurrentWeather(city, WEATHER_API_KEY)
    }
}
