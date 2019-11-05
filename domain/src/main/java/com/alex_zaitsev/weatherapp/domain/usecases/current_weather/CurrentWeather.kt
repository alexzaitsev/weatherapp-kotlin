package com.alex_zaitsev.weatherapp.domain.usecases.current_weather

import com.alex_zaitsev.weatherapp.data.api.CurrentWeatherResponse
import com.alex_zaitsev.weatherapp.data.api.ErrorResponse

sealed class CurrentWeatherResult {
    data class Data(
        val visibility: Int,
        val temperature: Double,
        val pressure: Int,
        val humidity: Int,
        val tempMin: Double,
        val tempMax: Double
    ) : CurrentWeatherResult()

    data class Error(
        val code: Int,
        val message: String
    ) : CurrentWeatherResult() {
        constructor(): this(0, "")
    }
}

internal fun CurrentWeatherResponse.mapToDomain() = CurrentWeatherResult.Data(
    visibility = this.visibility,
    temperature = this.main.temperature,
    pressure = this.main.pressure,
    humidity = this.main.humidity,
    tempMin = this.main.tempMin,
    tempMax = this.main.tempMax
)

internal fun ErrorResponse.mapToDomain() = CurrentWeatherResult.Error(
    code = this.code,
    message = this.message
)