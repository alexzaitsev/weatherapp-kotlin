package com.alex_zaitsev.weatherapp.data

import com.alex_zaitsev.weatherapp.data.api.ErrorResponse
import com.google.gson.Gson
import okhttp3.ResponseBody

fun ResponseBody.map(): ErrorResponse = Gson().fromJson(charStream(), ErrorResponse::class.java)
