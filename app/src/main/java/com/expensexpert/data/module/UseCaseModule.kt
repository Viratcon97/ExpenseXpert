package com.expensexpert.data.module

import com.expensexpert.data.GetWeatherResponseUseCase
import com.expensexpert.data.WeatherRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetWeatherResponseUsecase(weatherRepository: WeatherRepository) : GetWeatherResponseUseCase {
        return GetWeatherResponseUseCase(weatherRepository)
    }
}