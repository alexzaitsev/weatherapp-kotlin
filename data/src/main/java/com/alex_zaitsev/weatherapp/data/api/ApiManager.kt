package com.alex_zaitsev.weatherapp.data.api

import com.alex_zaitsev.weatherapp.data.api.models.CurrentWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiManager {

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("APPID") appId: String
    ): Response<CurrentWeatherResponse>
}
