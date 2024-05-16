package com.example.weatherapp.presentation.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MainWeather(

    @SerializedName("temp")
    val temp: Double?,

    @SerializedName("pressure")
    val pressure: Double?,

    @SerializedName("temp_max")
    val tempMax: Double?,

    @SerializedName("temp_min")
    val tempMin: Double?,

    @SerializedName("humidity")
    val humidity: Double?

) : Serializable