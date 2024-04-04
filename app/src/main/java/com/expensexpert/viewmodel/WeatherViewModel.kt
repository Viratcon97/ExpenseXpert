package com.expensexpert.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.expensexpert.data.GetWeatherResponseUseCase

class WeatherViewModel(private val getWeatherResponseUseCase: GetWeatherResponseUseCase) : ViewModel() {

    fun getData() = liveData {
        val weatherData = getWeatherResponseUseCase.execute()
        emit(weatherData)
    }
}