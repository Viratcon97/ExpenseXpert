package com.expensexpert.data

interface Injector {
    fun createWeatherSubComponent() : WeatherSubComponent
}