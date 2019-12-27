package com.alex_zaitsev.weatherapp.data.mappers

import com.alex_zaitsev.weatherapp.data.DataError
import com.alex_zaitsev.weatherapp.data.DataResult
import com.alex_zaitsev.weatherapp.data.api.models.ErrorResponse

internal fun ErrorResponse.map() = DataError(
    code = code,
    message = message
)
