package com.alex_zaitsev.weatherapp.data.api.response

import com.google.gson.annotations.SerializedName

class CurrentWeatherResponse(
    @SerializedName("name") val name: String,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("main") val main: Main,
    @SerializedName("weather") val weather: List<Weather>
) {

    class Main(
        @SerializedName("temp") val temperature: Double,
        @SerializedName("pressure") val pressure: Int,
        @SerializedName("humidity") val humidity: Int,
        @SerializedName("temp_min") val tempMin: Double,
        @SerializedName("temp_max") val tempMax: Double
    )

    class Weather(
        @SerializedName("id") val id: Int,
        @SerializedName("main") val type: String,
        @SerializedName("description") val descr: String,
        @SerializedName("icon") val icon: String
    )
}
