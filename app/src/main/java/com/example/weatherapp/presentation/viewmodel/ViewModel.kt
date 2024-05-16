package com.example.weatherapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.datasource.ApiResponse
import com.example.weatherapp.domain.Repository
import com.example.weatherapp.presentation.data.LatLon
import com.example.weatherapp.presentation.data.Weather
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val repository = Repository()

    private val _locationLiveData = MutableLiveData<ApiResponse<List<LatLon>>>()
    private val _weatherLiveData = MutableLiveData<ApiResponse<Weather>>()
    val locationLiveData: LiveData<ApiResponse<List<LatLon>>> = _locationLiveData
    val weatherLiveData: LiveData<ApiResponse<Weather>> = _weatherLiveData

    fun getLocation(country: String) {
        viewModelScope.launch {
            _locationLiveData.value = repository.getLocation(country)
        }
    }

    fun getWeather(location: LatLon) {
        viewModelScope.launch {
            _weatherLiveData.value = repository.getWeather(location)
        }
    }
}