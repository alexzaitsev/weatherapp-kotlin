package com.alex_zaitsev.weatherapp.view.utils

import android.content.Context
import android.net.ConnectivityManager

val Context.isConnected: Boolean
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnectedOrConnecting == true
    }