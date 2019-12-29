package com.alex_zaitsev.weatherapp.view.settings

import androidx.lifecycle.MutableLiveData
import com.alex_zaitsev.weatherapp.view.BaseViewModel

class SettingsViewModel : BaseViewModel() {

    /**
     * City name entered by user
     */
    val inputCity = MutableLiveData<String>()
}
