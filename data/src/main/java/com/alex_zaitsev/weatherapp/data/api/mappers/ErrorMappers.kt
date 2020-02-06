package com.alex_zaitsev.weatherapp.data.api.mappers

import com.alex_zaitsev.weatherapp.data.DataError
import com.alex_zaitsev.weatherapp.data.api.models.ErrorResponse

internal fun ErrorResponse.map() = DataError(
    code = code,
    message = message
)
