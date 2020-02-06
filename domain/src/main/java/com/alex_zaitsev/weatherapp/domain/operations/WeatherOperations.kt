package com.alex_zaitsev.weatherapp.domain.operations

import com.alex_zaitsev.weatherapp.data.DataResult
import com.alex_zaitsev.weatherapp.data.repositories.CityRepository
import com.alex_zaitsev.weatherapp.data.repositories.WeatherRepository
import com.alex_zaitsev.weatherapp.domain.DomainResult
import com.alex_zaitsev.weatherapp.domain.Operations
import com.alex_zaitsev.weatherapp.domain.mapToDomain
import com.alex_zaitsev.weatherapp.entity.models.Weather

class WeatherOperations(
    private val cityRepository: CityRepository,
    private val weatherRepository: WeatherRepository
) : Operations() {

    suspend fun checkAndCacheWeather(city: String): DomainResult<Boolean> =
        when (val result = weatherRepository.getWeather(city)) {
            is DataResult.Success -> DomainResult.Success(true)
            is DataResult.Error -> DomainResult.Error(result.mapToDomain().error)
        }

    suspend fun getWeather(): DomainResult<Weather> =
        when (val result = weatherRepository.getCachedWeather()) {
            is DataResult.Success -> DomainResult.Success(result.value)
            is DataResult.Error ->
                when (val cityResult = cityRepository.getCity()) {
                    is DataResult.Success ->
                        when (val weatherResult =
                            weatherRepository.getWeather(cityResult.value.name)) {
                            is DataResult.Success -> DomainResult.Success(weatherResult.value)
                            is DataResult.Error -> result.mapToDomain()
                        }
                    is DataResult.Error -> result.mapToDomain()
                }
        }
}
