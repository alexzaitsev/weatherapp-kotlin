package com.alex_zaitsev.weatherapp.view.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.alex_zaitsev.weatherapp.R
import com.alex_zaitsev.weatherapp.databinding.ActivityMainBinding
import com.alex_zaitsev.weatherapp.view.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.currentWeather.observe(this) {
            binding.mainWeather.currentWeather = it
        }
        binding.executePendingBindings()
    }
}
