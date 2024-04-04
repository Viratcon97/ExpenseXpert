package com.expensexpert.data

import com.expensexpert.data.model.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(): WeatherResponse
}