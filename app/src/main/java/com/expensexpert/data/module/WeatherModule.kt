package com.expensexpert.data.module

import com.expensexpert.data.GetWeatherResponseUseCase
import com.expensexpert.data.WeatherScope
import com.expensexpert.viewmodel.WeatherViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class WeatherModule {

    @WeatherScope
    @Provides
    fun provideWeatherViewModelFactory(getWeatherResponseUseCase: GetWeatherResponseUseCase) : WeatherViewModelFactory{
        return WeatherViewModelFactory(
            getWeatherResponseUseCase
        )
    }
}