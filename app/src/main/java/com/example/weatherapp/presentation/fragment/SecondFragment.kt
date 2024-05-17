package com.example.weatherapp.presentation.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.databinding.FragmentSecondBinding
import com.example.weatherapp.presentation.data.Weather

class SecondFragment : Fragment() {

    companion object {
        const val ACTION_WEATHER = "actionWeather"
    }

    private var binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        val weather = arguments?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable(ACTION_WEATHER, Weather::class.java)
            } else {
                it.getSerializable(ACTION_WEATHER) as Weather
            }
        }

        binding?.initViews(weather)

        return binding?.root
    }

    private fun FragmentSecondBinding.initViews(weather: Weather?) {
        weather?.main?.let {
            tvTemp.text = "Temperature = ${it.temp.toString()}"
            tvTempMax.text="Maximum temperature = ${it.tempMax.toString()}"
            tvTempMin.text="Minimum temperature = ${it.tempMin.toString()}"
            tvHumidity.text="Humidity = ${it.humidity.toString()}"
            tvPressure.text="Pressure = ${it.pressure.toString()}"
        }
        weather?.wind?.let {
            tvSpeed.text = "Wind speed = ${it.speed.toString()}"
            tvDeg.text="Wind direction = ${it.deg.toString()}"
            tvGust.text="Wind gust = ${it.gust.toString()}"
        }
         tvRain.text = " Rain volume(last hour) = ${weather?.rain?.oneH.toString()} "
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}
