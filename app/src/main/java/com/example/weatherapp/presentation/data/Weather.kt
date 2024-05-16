package com.example.weatherapp.presentation.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Weather(

    @SerializedName("main")
    val main: MainWeather?,

    @SerializedName("wind")
    val wind: Wind?,

    @SerializedName("clouds")
    val cloud: Cloud?,

    @SerializedName("rain")
    val rain: Rain?


) : Serializable