package com.alex_zaitsev.weatherapp.data.api

import com.alex_zaitsev.weatherapp.data.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {

    single<Interceptor>(named("logInterceptor")) {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }

    single {
        val builder = OkHttpClient.Builder()

        // setting log interceptor
        if (BuildConfig.DEBUG) {
            val logInterceptor by inject<HttpLoggingInterceptor>(named("logInterceptor"))
            builder.addNetworkInterceptor(logInterceptor)
        }

        // build OkHttpClient
        builder.readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS)
        builder.connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
        builder.build()
    }

    single<Gson> {
        GsonBuilder().create()
    }

    single<ApiManager> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiManager::class.java)
    }
}
