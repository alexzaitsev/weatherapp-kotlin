package com.alex_zaitsev.weatherapp.data.prefs

import android.content.SharedPreferences
import com.alex_zaitsev.weatherapp.entity.models.City

class PrefsManager(
    private val prefs: SharedPreferences
) {

    fun getCity(): City? {
        val id = prefs.getInt(PREF_CITY_ID, 0)
        val name = prefs.getString(PREF_CITY_NAME, null)
        if (id != 0 && name != null) {
            return City(id, name)
        }
        return null
    }

    fun saveCity(city: City) {
        prefs.edit()
            .putInt(PREF_CITY_ID, city.id)
            .putString(PREF_CITY_NAME, city.name)
            .apply()
    }

    companion object {
        const val PREF_CITY_ID = "PREF_CITY_ID"
        const val PREF_CITY_NAME = "PREF_CITY_NAME"
    }
}
