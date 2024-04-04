package com.expensexpert.data

import com.expensexpert.data.model.WeatherResponse

class WeatherDatasourceImpl(private val apiService: ApiService, private val city : String) : WeatherDatasource {
    override suspend fun getWeatherDatasource(): WeatherResponse = apiService.currentWeather(city = city)

}