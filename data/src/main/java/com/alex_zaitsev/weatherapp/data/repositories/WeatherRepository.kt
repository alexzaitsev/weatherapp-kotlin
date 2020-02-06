package com.alex_zaitsev.weatherapp.data.repositories


import com.alex_zaitsev.weatherapp.data.DataResult
import com.alex_zaitsev.weatherapp.data.WEATHER_API_KEY
import com.alex_zaitsev.weatherapp.data.api.ApiManager
import com.alex_zaitsev.weatherapp.data.api.mappers.map
import com.alex_zaitsev.weatherapp.data.api.models.mapToError
import com.alex_zaitsev.weatherapp.data.inmemory.InMemoryManager
import com.alex_zaitsev.weatherapp.entity.models.Weather

class WeatherRepository(
    private val apiManager: ApiManager,
    private val inMemoryManager: InMemoryManager
) : Repository() {

    suspend fun getWeather(city: String): DataResult<Weather> {
        val response =
            apiManager.getCurrentWeather(city, WEATHER_API_KEY)
        return if (response.isSuccessful) {
            response.body()?.let {
                val weather = it.map().also { cacheWeather(it) }
                DataResult.Success(weather)
            } ?: DataResult.Error.empty()
        } else {
            response.errorBody()?.let {
                DataResult.Error<Weather>(
                    it.mapToError().map()
                )
            } ?: DataResult.Error.empty()
        }
    }

    fun getCachedWeather(): DataResult<Weather> =
        inMemoryManager.weather?.let { DataResult.Success(it) } ?: DataResult.Error.empty()

    fun cacheWeather(weather: Weather) {
        inMemoryManager.weather = weather
    }
}
