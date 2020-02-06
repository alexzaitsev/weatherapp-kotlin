package com.alex_zaitsev.weatherapp.data.api.mappers

import com.alex_zaitsev.weatherapp.data.api.models.CurrentWeatherResponse
import com.alex_zaitsev.weatherapp.entity.models.City
import com.alex_zaitsev.weatherapp.entity.models.CurrentWeather
import com.alex_zaitsev.weatherapp.entity.models.Weather
import java.util.*

internal fun CurrentWeatherResponse.map() = Weather(
    city = City(
        id = id,
        name = name
    ),
    current = CurrentWeather(
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
)
