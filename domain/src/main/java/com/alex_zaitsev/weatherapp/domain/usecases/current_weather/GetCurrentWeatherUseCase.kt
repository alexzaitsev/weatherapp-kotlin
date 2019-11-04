package com.alex_zaitsev.weatherapp.domain.usecases.current_weather

import com.alex_zaitsev.weatherapp.data.WeatherRepository
import com.alex_zaitsev.weatherapp.domain.usecases.DomainConst.Companion.WEATHER_API_KEY
import com.alex_zaitsev.weatherapp.domain.usecases.UseCase

class GetCurrentWeatherUseCase(private val weatherRepository: WeatherRepository) : UseCase() {

    suspend fun get(city: String): CurrentWeather? {
        val response = weatherRepository.getCurrentWeather(city, WEATHER_API_KEY).await()
        if (response.isSuccessful) {
            return response.body()?.mapToDomain()
        }
        return null
    }
}
