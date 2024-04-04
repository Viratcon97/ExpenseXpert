package com.expensexpert.data

import com.expensexpert.data.module.AppModule
import com.expensexpert.data.module.DataModule
import com.expensexpert.data.module.NetModule
import com.expensexpert.data.module.RepositoryModule
import com.expensexpert.data.module.UseCaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataModule::class,
    UseCaseModule::class,
    RepositoryModule::class
])
interface AppComponent {
    fun weatherSubComponent() : WeatherSubComponent.Factory
}