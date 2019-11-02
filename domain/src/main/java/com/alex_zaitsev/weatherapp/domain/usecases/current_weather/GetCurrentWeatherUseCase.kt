package com.alex_zaitsev.weatherapp.domain.usecases.current_weather

import com.alex_zaitsev.weatherapp.data.WeatherRepository
import com.alex_zaitsev.weatherapp.data.api.CurrentWeatherResponse
import com.alex_zaitsev.weatherapp.data.api.WeatherApiManager
import com.alex_zaitsev.weatherapp.domain.usecases.UseCase
import javax.inject.Inject

class GetCurrentWeatherUseCase
    @Inject constructor(val weatherRepository: WeatherRepository)
    : UseCase() {

    fun get(city: String): CurrentWeather {
        val response = weatherRepository.getCurrentWeather(city, "")
    }
}
