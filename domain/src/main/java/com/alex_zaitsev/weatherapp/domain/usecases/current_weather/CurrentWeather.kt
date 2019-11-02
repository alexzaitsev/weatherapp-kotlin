package com.alex_zaitsev.weatherapp.domain.usecases.current_weather

import com.alex_zaitsev.weatherapp.data.api.CurrentWeatherResponse

data class CurrentWeather(
    val visibility: Int,
    val temperature: Double,
    val pressure: Int,
    val humidity: Int,
    val tempMin: Double,
    val tempMax: Double
)

fun CurrentWeatherResponse.mapToDomain() = CurrentWeather(
    visibility = this.visibility,
    temperature = this.main.temperature,
    pressure = this.main.pressure,
    humidity = this.main.humidity,
    tempMin = this.main.tempMin,
    tempMax = this.main.tempMax
)
