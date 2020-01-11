package com.alex_zaitsev.weatherapp.data.prefs

import android.content.Context
import org.koin.dsl.module

val prefsModule = module {
    single { (context: Context) -> context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }
    single { PrefsManager(get()) }
}
