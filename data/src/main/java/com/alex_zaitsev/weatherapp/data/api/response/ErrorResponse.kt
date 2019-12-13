package com.alex_zaitsev.weatherapp.data.api.response

import com.google.gson.annotations.SerializedName

class ErrorResponse(
    @SerializedName("cod")
    val code: Int,
    @SerializedName("message")
    val message: String
)