package com.alex_zaitsev.weatherapp.data.api.models

import com.google.gson.annotations.SerializedName

class CurrentWeatherResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("main") val main: Main,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("sys") val sys: Sys
) {

    class Main(
        @SerializedName("temp") val temperature: Double,
        @SerializedName("feels_like") val feelsLike: Double,
        @SerializedName("pressure") val pressure: Int,
        @SerializedName("humidity") val humidity: Int
    )

    class Wind(
        @SerializedName("speed") val speed: Int,
        @SerializedName("deg") val deg: Int
    )

    class Clouds(
        @SerializedName("all") val all: Int
    )

    class Sys(
        @SerializedName("country") val country: String,
        @SerializedName("sunrise") val sunrise: Long,
        @SerializedName("sunset") val sunset: Long
    )
}
