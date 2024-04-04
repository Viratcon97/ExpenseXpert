package com.expensexpert.data.module

import com.expensexpert.data.ApiService
import com.expensexpert.data.WeatherDatasource
import com.expensexpert.data.WeatherDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule (private val city : String) {

    @Singleton
    @Provides
    fun provideWeatherDatasource(apiService: ApiService) : WeatherDatasource {
        return WeatherDatasourceImpl(apiService, city)
    }
}