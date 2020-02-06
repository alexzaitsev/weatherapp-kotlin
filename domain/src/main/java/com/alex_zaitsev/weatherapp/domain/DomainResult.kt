package com.alex_zaitsev.weatherapp.domain

import com.alex_zaitsev.weatherapp.data.DataError
import com.alex_zaitsev.weatherapp.data.DataResult

sealed class DomainResult<T> {
    data class Success<T>(val value: T): DomainResult<T>()
    data class Error<T>(val error: DomainError) : DomainResult<T>()
}

sealed class DomainError {
    object NotFound : DomainError()
    data class General(val code: Int, val message: String) : DomainError()
}

internal fun DataError.mapToDomain(): DomainError = when (code) {
    HTTP_CODE_ERROR_NOT_FOUND -> DomainError.NotFound
    else -> DomainError.General(code, message)
}

internal fun <T> DataResult.Error<T>.mapToDomain() = DomainResult.Error<T>(error.mapToDomain())
