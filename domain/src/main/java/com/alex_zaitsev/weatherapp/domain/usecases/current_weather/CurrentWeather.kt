package com.alex_zaitsev.weatherapp.domain.usecases.current_weather

import com.alex_zaitsev.weatherapp.data.api.response.CurrentWeatherResponse
import com.alex_zaitsev.weatherapp.data.api.response.ErrorResponse

sealed class CurrentWeatherResult {
    data class Data(
        val name: String,
        val main: Main,
        val weather: List<Weather>
    ) : CurrentWeatherResult() {

        data class Main(
            val visibility: Int,
            val temperature: Double,
            val pressure: Int,
            val humidity: Int,
            val tempMin: Double,
            val tempMax: Double
        )

        data class Weather(
            val id: Int,
            val type: String,
            val descr: String,
            val icon: String
        )
    }

    data class Error(
        val code: Int,
        val message: String
    ) : CurrentWeatherResult() {
        constructor(): this(0, "")
    }
}

internal fun CurrentWeatherResponse.mapToDomain() = CurrentWeatherResult.Data(
    name = this.name,
    main = CurrentWeatherResult.Data.Main(
        visibility = this.visibility,
        temperature = this.main.temperature,
        pressure = this.main.pressure,
        humidity = this.main.humidity,
        tempMin = this.main.tempMin,
        tempMax = this.main.tempMax
    ),
    weather = this.weather.map {
        CurrentWeatherResult.Data.Weather(
            id = it.id,
            type = it.type,
            descr = it.descr,
            icon = it.icon
        )
    }
)

internal fun ErrorResponse.mapToDomain() = CurrentWeatherResult.Error(
    code = this.code,
    message = this.message
)