package com.alex_zaitsev.weatherapp.data.mappers

import com.alex_zaitsev.weatherapp.data.api.models.CurrentWeatherResponse
import com.alex_zaitsev.weatherapp.entity.models.CurrentWeather
import java.util.*

internal fun CurrentWeatherResponse.map() = CurrentWeather(
    visibility = visibility,
    temperature = main.temperature,
    feelsLike = main.feelsLike,
    pressure = main.pressure,
    humidity = main.humidity,
    windDeg = wind.deg,
    windSpeed = wind.speed,
    clouds = clouds.all,
    sunrise = Date(sys.sunrise),
    sunset = Date(sys.sunset)
)
