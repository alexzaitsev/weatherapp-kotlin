package com.alex_zaitsev.weatherapp.data._di

import com.alex_zaitsev.weatherapp.data.BuildConfig
import com.alex_zaitsev.weatherapp.data.api.ApiConst
import com.alex_zaitsev.weatherapp.data.api.WeatherApiManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named


@Module
class ApiModule {

    @Provides
    @Named("logInterceptor")
    internal fun provideLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    internal fun provideOkHttpClient(
        @Named("logInterceptor") logInterceptor: Interceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(logInterceptor)
        }
        return builder.build()
    }

    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder()
            //.registerTypeAdapter(ApiDeviceState::class.java, DeviceStateDeserializer())
            .create()
    }

    @Provides
    internal fun provideRetrofitBuilder(
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .baseUrl(ApiConst.WEATHER_BASE_URL)
    }

    @Provides
    internal fun provideApiManager(builder: Retrofit.Builder): WeatherApiManager {
        return builder.build().create<WeatherApiManager>(WeatherApiManager::class.java!!)
    }
}
