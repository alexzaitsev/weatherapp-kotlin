package com.alex_zaitsev.weatherapp.domain.operations

import com.alex_zaitsev.weatherapp.data.DataResult
import com.alex_zaitsev.weatherapp.data.repositories.CityRepository
import com.alex_zaitsev.weatherapp.domain.DomainResult
import com.alex_zaitsev.weatherapp.domain.mapToDomain
import com.alex_zaitsev.weatherapp.entity.models.City

class SettingsOperations(
    private val cityRepository: CityRepository
) {

    fun getCity(): DomainResult<City> =
        when (val result = cityRepository.getCity()) {
            is DataResult.Success -> DomainResult.Success(result.value)
            is DataResult.Error -> result.mapToDomain()
        }
}
