package com.alex_zaitsev.weatherapp.data


import com.alex_zaitsev.weatherapp.data.api.ApiManager
import com.alex_zaitsev.weatherapp.data.api.models.mapToError
import com.alex_zaitsev.weatherapp.data.mappers.map
import com.alex_zaitsev.weatherapp.entity.models.CurrentWeather

class DataRepository(private val apiManager: ApiManager) {

    suspend fun getCurrentWeather(city: String): DataResult<CurrentWeather> {
        val response = apiManager.getCurrentWeather(city, WEATHER_API_KEY)
        return if (response.isSuccessful) {
            response.body()?.let {
                DataResult.Success(it.map())
            } ?: DataResult.Error.empty()
        } else {
            response.errorBody()?.let {
                DataResult.Error<CurrentWeather>(it.mapToError().map())
            } ?: DataResult.Error.empty()
        }
    }
}
