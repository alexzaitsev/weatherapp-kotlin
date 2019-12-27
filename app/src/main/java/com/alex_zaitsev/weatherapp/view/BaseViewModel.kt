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

    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    protected val _error = MutableLiveData<Int>()
    val error: LiveData<Int>
        get() = _error

    protected val _errorTemplate = MutableLiveData<Pair<Int, String?>>()
    val errorTemplate: LiveData<Pair<Int, String?>>
        get() = _errorTemplate

    protected val _openLogin = SingleLiveEvent<Void>()
    val openLogin: LiveData<Void>
        get() = _openLogin

    fun asyncRunIfConnected(callback: suspend () -> Unit) {
        if (isNetworkAvailable.value == true) {
            asyncRunWithProgress(callback)
        } else {
            _error.value = R.string.error_network
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
