package com.alex_zaitsev.weatherapp.view

sealed class UiError {
    data class Message(val message: String): UiError()
    data class Resource(val messageId: Int): UiError()
    data class Template(val messageId: Int, val message: String): UiError()
}
