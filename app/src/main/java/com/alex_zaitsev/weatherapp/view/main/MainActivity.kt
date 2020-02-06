package com.alex_zaitsev.weatherapp.view.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.alex_zaitsev.weatherapp.R
import com.alex_zaitsev.weatherapp.databinding.ActivityMainBinding
import com.alex_zaitsev.weatherapp.view.BaseActivity
import kotlinx.android.synthetic.main.toolbar.view.*
import org.koin.android.ext.android.get

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun setViewModel() {
        viewModel = get()
    }

    override fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        observe()
        loadData()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbarLayout.toolbar)
    }

    override fun observe() {
        super.observe()
        viewModel.data.observe(this) { binding.content.currentWeather = it }
    }

    private fun loadData() {
        viewModel.loadData()
    }
}
