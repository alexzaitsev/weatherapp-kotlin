package com.alex_zaitsev.weatherapp.view.settings

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.alex_zaitsev.weatherapp.R
import com.alex_zaitsev.weatherapp.databinding.ActivitySettingsBinding
import com.alex_zaitsev.weatherapp.view.BaseActivity
import kotlinx.android.synthetic.main.toolbar.view.*
import org.koin.android.ext.android.get

class SettingsActivity : BaseActivity<ActivitySettingsBinding, SettingsViewModel>() {

    override fun setViewModel() {
        viewModel = get()
    }

    override fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        observe()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbarLayout.toolbar)
    }

    override fun observe() {
        super.observe()
        viewModel.inputCity.observe(this) { viewModel.loadWeather(it) }
    }
}
