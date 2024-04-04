package com.expensexpert.data

import com.expensexpert.data.model.WeatherResponse

class GetWeatherResponseUseCase(private val weatherRepository: WeatherRepository) {
    suspend fun execute () : WeatherResponse = weatherRepository.getWeather()
}