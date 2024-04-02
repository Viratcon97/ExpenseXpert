package com.expensexpert.data

import retrofit2.Response
import retrofit2.http.Query

interface ApiService {

/*    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") key: String = ApiConfig.API_KEY,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): Call<WeatherResponse>*/

    suspend fun currentWeather(
        @Query("key") key: String = ApiConfig.API_KEY,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ) : Response<WeatherResponse>
}