package com.example.weatherapp.presentation.data

import com.google.gson.annotations.SerializedName

data class LatLon(

    @SerializedName("lat")
    val lat: String?,

    @SerializedName("lon")
    val lon: String?
)