package com.alex_zaitsev.weatherapp.domain.usecases.current_weather

import com.alex_zaitsev.weatherapp.data.WeatherRepository
import com.alex_zaitsev.weatherapp.data.map
import com.alex_zaitsev.weatherapp.domain.usecases.DomainConst.Companion.WEATHER_API_KEY
import com.alex_zaitsev.weatherapp.domain.usecases.UseCase

class GetCurrentWeatherUseCase(private val weatherRepository: WeatherRepository) : UseCase() {

    suspend fun get(city: String): CurrentWeatherResult {
        val response = weatherRepository.getCurrentWeather(city, WEATHER_API_KEY)
        return if (response.isSuccessful) {
            response.body()?.mapToDomain() ?: CurrentWeatherResult.Error()
        } else {
            response.errorBody()?.map()?.mapToDomain() ?: CurrentWeatherResult.Error()
        }
    }
}
