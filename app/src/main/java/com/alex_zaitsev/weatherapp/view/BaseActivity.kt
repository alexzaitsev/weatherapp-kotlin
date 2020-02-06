package com.alex_zaitsev.weatherapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.observe
import com.alex_zaitsev.weatherapp.view.utils.isConnected
import com.alex_zaitsev.weatherapp.view.utils.livedata.ConnectionLiveData
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: DB
    private lateinit var connectionLiveData: ConnectionLiveData

    abstract fun setViewModel()

    abstract fun setBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
        setBinding()
        connectionLiveData = ConnectionLiveData(this)
    }

    open fun observe() {
        connectionLiveData.observe(this) { viewModel.isNetworkAvailable.value = it }
        viewModel.isNetworkAvailable.value = isConnected
        viewModel.error.observe(this) { processUiError(binding.root, it) }
    }

    private fun processUiError(view: View, err: UiError) {
        when (err) {
            is UiError.Message -> showSnackbar(view, err.message)
            is UiError.Resource -> showSnackbar(view, err.messageId)
            is UiError.Template -> showSnackbar(view, "${getString(err.messageId)}: ${err.message}")
        }
    }

    private fun showSnackbar(view: View, string: String) {
        Snackbar.make(view, string, Snackbar.LENGTH_SHORT).show()
    }

    private fun showSnackbar(view: View, stringId: Int) {
        Snackbar.make(view, stringId, Snackbar.LENGTH_SHORT).show()
    }
}
