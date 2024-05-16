package com.example.weatherapp.presentation.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cloud(
    
    @SerializedName("all")
    val all: Int?
) : Serializable