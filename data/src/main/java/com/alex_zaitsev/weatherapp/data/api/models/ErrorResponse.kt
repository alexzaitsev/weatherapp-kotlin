package com.alex_zaitsev.weatherapp.data.api.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody

class ErrorResponse(
    @SerializedName("cod")
    val code: Int,
    @SerializedName("message")
    val message: String
)

fun ResponseBody.mapToError(): ErrorResponse = Gson().fromJson(charStream(), ErrorResponse::class.java)
