package com.expensexpert.data

import com.expensexpert.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

/*    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") key: String = ApiConfig.API_KEY,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): Call<WeatherResponse>*/

    @GET("current.json")
    suspend fun currentWeather(
        @Query("key") key: String = "5907913ab51b4e2aab634653241103",
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ) : WeatherResponse
}