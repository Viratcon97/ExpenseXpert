package com.expensexpert.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.expensexpert.data.GetWeatherResponseUseCase

class WeatherViewModelFactory(private val getWeatherResponseUseCase: GetWeatherResponseUseCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(getWeatherResponseUseCase) as T
    }
}