package com.alex_zaitsev.weatherapp.data.api

class WeatherApiManager {

    fun getCurrentWeather(city: String): CurrentWeatherApi {
        return CurrentWeatherApi(
            city,
            "some weather description"
        )
    }
}