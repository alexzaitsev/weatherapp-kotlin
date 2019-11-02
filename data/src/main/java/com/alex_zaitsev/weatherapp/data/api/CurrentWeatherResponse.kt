package com.alex_zaitsev.weatherapp.data.api

import com.google.gson.annotations.SerializedName

class CurrentWeatherResponse(
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("main") val main: Main
) {

    class Main(
        @SerializedName("temp") val temperature: Double,
        @SerializedName("pressure") val pressure: Int,
        @SerializedName("humidity") val humidity: Int,
        @SerializedName("temp_min") val tempMin: Double,
        @SerializedName("temp_max") val tempMax: Double
    )
}
