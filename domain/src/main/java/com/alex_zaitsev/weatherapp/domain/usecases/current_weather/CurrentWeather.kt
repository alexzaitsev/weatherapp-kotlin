package com.alex_zaitsev.weatherapp.domain.usecases.current_weather

import com.alex_zaitsev.weatherapp.data.api.CurrentWeatherApi

data class CurrentWeather(val city: String, val description: String)

fun CurrentWeatherApi.mapToDomain() = CurrentWeather(city = this.city,
    description = this.description)