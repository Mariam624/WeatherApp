package com.example.weatherapp.presentation.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Wind(

    @SerializedName("speed")
    val speed: Double?,

    @SerializedName("deg")
    val deg: Double?,

    @SerializedName("gust")
    val gust: Double?,

) : Serializable