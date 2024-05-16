package com.example.weatherapp.datasource

import com.example.weatherapp.presentation.data.LatLon
import com.example.weatherapp.presentation.data.Weather
import retrofit2.Response
import retrofit2.http.*

private const val API_KEY: String = "&appid=154efb402bd8869275d0622e505c264c"

interface ApiInterface {

    @GET("geo/1.0/direct?limit=1${API_KEY}")
    suspend fun getLocation(@Query("q") country: String): Response<List<LatLon>>

    @GET("data/2.5/weather?${API_KEY}")
    suspend fun getWeather(@Query("lat") lat: String, @Query("lon") lon: String): Response<Weather>
}