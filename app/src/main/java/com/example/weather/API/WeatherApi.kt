package com.example.weather.API


import androidx.lifecycle.ViewModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apikey: String,
        @Query("Q") city:String
    ) :Response<ViewModel>

}