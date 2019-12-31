package com.alex_zaitsev.weatherapp.data.repositories


import com.alex_zaitsev.weatherapp.data.DataResult
import com.alex_zaitsev.weatherapp.data.WEATHER_API_KEY
import com.alex_zaitsev.weatherapp.data.api.ApiManager
import com.alex_zaitsev.weatherapp.data.api.models.mapToError
import com.alex_zaitsev.weatherapp.data.mappers.map
import com.alex_zaitsev.weatherapp.entity.models.CurrentWeather

class WeatherRepository(
    private val apiManager: ApiManager
): Repository() {

    suspend fun getCurrentWeather(city: String): DataResult<CurrentWeather> {
        val response = apiManager.getCurrentWeather(city,
            WEATHER_API_KEY
        )
        return if (response.isSuccessful) {
            response.body()?.let {
                DataResult.Success(it.map())
            } ?: DataResult.Error.empty()
        } else {
            response.errorBody()?.let {
                DataResult.Error<CurrentWeather>(
                    it.mapToError().map()
                )
            } ?: DataResult.Error.empty()
        }
    }
}
