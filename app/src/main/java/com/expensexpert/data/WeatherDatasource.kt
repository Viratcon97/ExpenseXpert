package com.expensexpert.data

import com.expensexpert.data.model.WeatherResponse

interface WeatherDatasource {
    suspend fun getWeatherDatasource() : WeatherResponse
}