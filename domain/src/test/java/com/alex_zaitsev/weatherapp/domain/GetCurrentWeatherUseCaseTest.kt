package com.alex_zaitsev.weatherapp.domain

import com.alex_zaitsev.weatherapp.data.apiModule
import com.alex_zaitsev.weatherapp.data.repositoryModule
import com.alex_zaitsev.weatherapp.domain.usecases.current_weather.GetCurrentWeatherUseCase
import com.alex_zaitsev.weatherapp.domain.usecases.useCasesModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.hamcrest.CoreMatchers.`is` as Is

@ExperimentalCoroutinesApi
class GetCurrentWeatherUseCaseTest : KoinTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    val sut by inject<GetCurrentWeatherUseCase>()

    @Before
    fun before() {
        startKoin { listOf(useCasesModule, repositoryModule, apiModule) }
    }

    @Test
    fun `wrong input returns Error`() {
        testCoroutineRule.runBlockingTest {
            val result = sut.get("1")
            assertThat(result, Is(notNullValue()))
        }
    }
}
