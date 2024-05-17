package com.example.weatherapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentFirstBinding
import com.example.weatherapp.datasource.ApiResponse
import com.example.weatherapp.presentation.data.LatLon
import com.example.weatherapp.presentation.data.Weather
import com.example.weatherapp.presentation.viewmodel.ViewModel
import com.google.android.material.snackbar.Snackbar


class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null

    private val viewModel by viewModels<ViewModel>()

    private val locationObserver = Observer<ApiResponse<List<LatLon>>> { apiResponse ->
        when (apiResponse) {
            is ApiResponse.Success -> {
                val data = apiResponse.data
                if (data.isNotEmpty()) {
                    viewModel.getWeather(data[0])
                } else {
                    // Handle the case when the list is empty
                    val snackbar = Snackbar.make(binding!!.root, "No results found for your search", Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
            }

            is ApiResponse.Failure -> {
                val snackbar = Snackbar.make(binding!!.root, "No results found for your search", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
        }
    }

    private val weatherObserver = Observer<ApiResponse<Weather>> { response ->
        if (response is ApiResponse.Success) {
            val bundle = bundleOf(SecondFragment.ACTION_WEATHER to response.data)
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.initViews()
        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

    private fun FragmentFirstBinding.initViews() {
        btnSearch.setOnClickListener{
            viewModel.getLocation(etCountry.text.toString())
        }
    }

    private fun initObservers() {
        viewModel.locationLiveData.observe(viewLifecycleOwner, locationObserver)
        viewModel.weatherLiveData.observe(viewLifecycleOwner, weatherObserver)
    }
}