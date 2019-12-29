package com.alex_zaitsev.weatherapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alex_zaitsev.weatherapp.view.utils.livedata.ConnectionLiveData
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectionLiveData = ConnectionLiveData(this)
    }

    protected fun showSnackbar(view: View, string: String) {
        Snackbar.make(view, string, Snackbar.LENGTH_SHORT).show()
    }

    protected fun showSnackbar(view: View, stringId: Int) {
        Snackbar.make(view, stringId, Snackbar.LENGTH_SHORT).show()
    }

    protected fun processUiError(view: View, err: UiError) {
        when (err) {
            is UiError.Message -> showSnackbar(view, err.message)
            is UiError.Resource -> showSnackbar(view, err.messageId)
            is UiError.Template -> showSnackbar(view, "${getString(err.messageId)}: ${err.message}")
        }
    }
}
