package com.alex_zaitsev.weatherapp.view._di

import com.alex_zaitsev.weatherapp.data._di.DataComponent
import com.alex_zaitsev.weatherapp.domain.usecases._di.DomainComponent
import com.alex_zaitsev.weatherapp.view.App
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class],
    dependencies = [DataComponent::class, DomainComponent::class])
@Singleton
interface AppComponent {

    fun inject(app: App)
}
