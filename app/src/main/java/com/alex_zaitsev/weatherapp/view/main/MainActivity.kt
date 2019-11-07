package com.alex_zaitsev.weatherapp.view.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.alex_zaitsev.weatherapp.R
import com.alex_zaitsev.weatherapp.databinding.ActivityMainBinding
import com.alex_zaitsev.weatherapp.view.BaseActivity
import com.alex_zaitsev.weatherapp.view.utils.ConnectionLiveData
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.executePendingBindings()

        viewModel.currentWeather.observe(this) {
            binding.mainWeather.currentWeather = it
        }
        connectionLiveData = ConnectionLiveData(this)
        connectionLiveData.observe(this) {
            viewModel.isNetworkAvailable.value = it
        }
        viewModel.errorResId.observe(this) {
            Snackbar.make(binding.content, it, Snackbar.LENGTH_SHORT).show()
        }
    }
}
