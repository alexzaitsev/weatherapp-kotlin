package com.alex_zaitsev.weatherapp.data.repositories

import com.alex_zaitsev.weatherapp.data.DataResult
import com.alex_zaitsev.weatherapp.data.prefs.PrefsManager
import com.alex_zaitsev.weatherapp.entity.models.City

class CityRepository(
    private val prefsManager: PrefsManager
) : Repository() {

    fun getCity(): DataResult<City> =
        prefsManager.getCity()?.let { DataResult.Success(it) } ?: DataResult.Error.empty()

    fun saveCity(city: City) = prefsManager.saveCity(city)
}
