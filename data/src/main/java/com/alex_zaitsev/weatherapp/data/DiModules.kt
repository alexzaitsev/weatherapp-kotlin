package com.alex_zaitsev.weatherapp.data

import com.alex_zaitsev.weatherapp.data.api.ApiConst
import com.alex_zaitsev.weatherapp.data.api.WeatherApiManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    single<Interceptor>(named("logInterceptor")) {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }

    single<OkHttpClient> {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logInterceptor: HttpLoggingInterceptor by inject(named("logInterceptor"))
            builder.addNetworkInterceptor(logInterceptor)
        }
        builder.build()
    }

    single<Gson> {
        GsonBuilder()
            //.registerTypeAdapter(ApiDeviceState::class.java, DeviceStateDeserializer())
            .create()
    }

    single<WeatherApiManager> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .baseUrl(ApiConst.WEATHER_BASE_URL)
            .build()
            .create(WeatherApiManager::class.java)
    }
}

val repositoryModule = module {

    single { WeatherRepository(get()) }
}