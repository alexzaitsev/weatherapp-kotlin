package com.alex_zaitsev.weatherapp.data

sealed class DataResult<T> {
    data class Success<T>(val value: T) : DataResult<T>()
    data class Error<T>(val error: DataError) : DataResult<T>() {
        companion object {
            fun <T> empty() = Error<T>(DataError.empty())
        }
    }
}

data class DataError(val code: Int, val message: String) {
    companion object {
        fun empty() = DataError(0, "")
    }
}
