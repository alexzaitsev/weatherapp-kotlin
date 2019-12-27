package com.alex_zaitsev.weatherapp.entity.models

import java.util.*

data class CurrentWeather(
    val id: String,
    val name: String,
    val visibility: Int,
    val temperature: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Int,
    val windDeg: Int,
    val clouds: Int,
    val sunrise: Date,
    val sunset: Date
)
