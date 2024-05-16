package com.example.weatherapp.domain

import com.example.weatherapp.datasource.Api
import com.example.weatherapp.datasource.ApiResponse
import com.example.weatherapp.datasource.makeCall
import com.example.weatherapp.presentation.data.LatLon

class Repository {

    suspend fun getLocation(country: String): ApiResponse<List<LatLon>> = makeCall {
        Api.client.getLocation(country)
    }

    suspend fun getWeather(latLon: LatLon) = makeCall {
        Api.client.getWeather(latLon.lat ?: "0", latLon.lon ?: "0")
    }
}