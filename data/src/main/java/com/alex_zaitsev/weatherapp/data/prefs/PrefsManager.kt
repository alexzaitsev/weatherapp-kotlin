package com.alex_zaitsev.weatherapp.data.prefs

import android.content.SharedPreferences
import com.alex_zaitsev.weatherapp.entity.models.City

class PrefsManager(
    private val prefs: SharedPreferences
) {

    fun getCity(): City? {
        val id = prefs.getString(PREF_CITY_ID, null)
        val name = prefs.getString(PREF_CITY_NAME, null)
        return if (id.isNullOrEmpty() || name.isNullOrEmpty()) null else City(id, name)
    }

    fun saveCity(city: City) {
        prefs.edit()
            .putString(PREF_CITY_ID, city.id)
            .putString(PREF_CITY_NAME, city.name)
            .apply()
    }

    companion object {
        const val PREF_CITY_ID = "PREF_CITY_ID"
        const val PREF_CITY_NAME = "PREF_CITY_NAME"
    }
}
