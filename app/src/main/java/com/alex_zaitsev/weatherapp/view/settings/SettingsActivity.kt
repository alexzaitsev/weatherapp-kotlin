package com.alex_zaitsev.weatherapp.view.settings

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.alex_zaitsev.weatherapp.R
import com.alex_zaitsev.weatherapp.databinding.ActivitySettingsBinding
import com.alex_zaitsev.weatherapp.view.BaseActivity
import com.alex_zaitsev.weatherapp.view.utils.isConnected
import kotlinx.android.synthetic.main.toolbar.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class SettingsActivity : BaseActivity() {

    private val viewModel by viewModel<SettingsViewModel>()
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        initToolbar()
        observe()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbarLayout.toolbar)
    }

    private fun observe() {
        connectionLiveData.observe(this) { viewModel.isNetworkAvailable.value = it }
        viewModel.isNetworkAvailable.value = isConnected
        viewModel.error.observe(this) { processUiError(binding.root, it) }
        viewModel.inputCity.observe(this) { viewModel.loadWeather(it) }
    }
}
