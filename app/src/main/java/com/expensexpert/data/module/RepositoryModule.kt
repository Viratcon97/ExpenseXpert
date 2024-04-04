package com.expensexpert.data.module

import com.expensexpert.data.WeatherDatasource
import com.expensexpert.data.WeatherRepository
import com.expensexpert.data.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositoryModule (
        weatherDatasource: WeatherDatasource
    ): WeatherRepository {

        return WeatherRepositoryImpl(
            weatherDatasource
        )
    }
}