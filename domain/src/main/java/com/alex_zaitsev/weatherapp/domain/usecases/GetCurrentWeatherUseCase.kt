package com.alex_zaitsev.weatherapp.domain.usecases

import com.alex_zaitsev.weatherapp.data.DataRepository
import com.alex_zaitsev.weatherapp.data.DataResult
import com.alex_zaitsev.weatherapp.domain.DomainResult
import com.alex_zaitsev.weatherapp.domain.mapToDomain
import com.alex_zaitsev.weatherapp.entity.models.CurrentWeather

class GetCurrentWeatherUseCase(private val dataRepository: DataRepository) : UseCase() {

    suspend fun get(city: String): DomainResult<CurrentWeather> =
        when (val result = dataRepository.getCurrentWeather(city)) {
            is DataResult.Success<CurrentWeather> -> DomainResult.Success(result.value)
            is DataResult.Error<CurrentWeather> -> result.mapToDomain()
        }
}
