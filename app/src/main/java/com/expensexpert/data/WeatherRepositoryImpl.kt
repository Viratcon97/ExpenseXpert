package com.expensexpert.data

import com.expensexpert.data.model.WeatherResponse

class WeatherRepositoryImpl(private val weatherDatasource: WeatherDatasource) : WeatherRepository {
    override suspend fun getWeather(): WeatherResponse {
        return getWeatherData()
    }

    private suspend fun getWeatherData() : WeatherResponse {
        lateinit var data: WeatherResponse
        val response = weatherDatasource.getWeatherDatasource()
        data = response
        return data
    }
}