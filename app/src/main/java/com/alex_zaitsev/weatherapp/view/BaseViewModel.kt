package com.alex_zaitsev.weatherapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex_zaitsev.weatherapp.R
import com.alex_zaitsev.weatherapp.view.utils.livedata.SingleLiveEvent
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    var isNetworkAvailable = MutableLiveData<Boolean>()

    protected val _isLoading = SingleLiveEvent<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    protected val _error = SingleLiveEvent<UiError>()
    val error: LiveData<UiError>
        get() = _error

    fun asyncRunIfConnected(callback: suspend () -> Unit) {
        if (isNetworkAvailable.value == true) {
            asyncRunWithProgress(callback)
        } else {
            _error.value = UiError.Resource(R.string.error_network)
        }
    }

    fun asyncRunWithProgress(callback: suspend () -> Unit) {
        _isLoading.value = true
        viewModelScope.launch {
            callback.invoke()
            _isLoading.value = false
        }
    }
}
