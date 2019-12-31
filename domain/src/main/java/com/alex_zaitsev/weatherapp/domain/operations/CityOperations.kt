package com.alex_zaitsev.weatherapp.domain.operations

import com.alex_zaitsev.weatherapp.data.DataResult
import com.alex_zaitsev.weatherapp.data.repositories.CityRepository
import com.alex_zaitsev.weatherapp.data.repositories.WeatherRepository
import com.alex_zaitsev.weatherapp.domain.DomainResult
import com.alex_zaitsev.weatherapp.domain.Operations
import com.alex_zaitsev.weatherapp.domain.mapToDomain
import com.alex_zaitsev.weatherapp.entity.models.City
import com.alex_zaitsev.weatherapp.entity.models.CurrentWeather

class CityOperations(
    private val cityRepository: CityRepository,
    private val weatherRepository: WeatherRepository
) : Operations() {

    /**
     * Returns saved city
     */
    fun getCity(): DomainResult<City> =
        when (val result = cityRepository.getCity()) {
            is DataResult.Success -> DomainResult.Success(result.value)
            is DataResult.Error -> result.mapToDomain()
        }

    suspend fun checkAndSaveIfExists(city: String): DomainResult<Boolean> {
        when (val result = weatherRepository.getCurrentWeather(city)) {
            is DataResult.Success<CurrentWeather> -> DomainResult.Success(result.value)
            is DataResult.Error<CurrentWeather> -> result.mapToDomain()
        }
    }
}
