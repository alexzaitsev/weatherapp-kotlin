package com.alex_zaitsev.weatherapp.domain.usecases.current_weather

import com.alex_zaitsev.weatherapp.data.api.weather.WeatherApiManager
import com.alex_zaitsev.weatherapp.domain.usecases.UseCase

class GetCurrentWeatherUseCase : UseCase() {

    private val apiManager = WeatherApiManager()

    fun get(city: String): CurrentWeather = apiManager.getCurrentWeather(city).mapToDomain()
}