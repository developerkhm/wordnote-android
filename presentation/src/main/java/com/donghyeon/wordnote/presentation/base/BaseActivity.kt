package com.donghyeon.wordnote.presentation.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import com.donghyeon.wordnote.presentation.R

abstract class BaseActivity<VDB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutRes: Int
) : AppCompatActivity() {

    companion object {
        private var toast: Toast? = null
        private var alert: AlertDialog? = null
    }

    protected lateinit var binding: VDB
    abstract val viewModel: VM

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        binding = setContentView<VDB>(this, layoutRes).apply {
            lifecycleOwner = this@BaseActivity
        }
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        viewModel.baseState.observe(this) {
            when (it) {
                is BaseState.ShowMessage -> showToast(it.message)
                is BaseState.KeyboardHide ->
                    imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        }
    }

    private fun showToast(
        message: String
    ) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.setText(message)
        toast?.show()
    }

    private fun showAlert1B(
        message: String,
        done: () -> Unit
    ) {
        alert?.dismiss()
        alert = AlertDialog.Builder(this)
            .setTitle(message)
            .setPositiveButton(getString(R.string.done)) { _, _ ->
                done.invoke()
            }
            .setCancelable(false)
            .create()
        alert?.show()
    }

    private fun showAlert2B(
        message: String,
        done: () -> Unit
    ) {
        alert?.dismiss()
        alert = AlertDialog.Builder(this)
            .setTitle(message)
            .setPositiveButton(getString(R.string.done)) { _, _ ->
                done.invoke()
            }
            .setNegativeButton(getString(R.string.cancel), null)
            .setCancelable(false)
            .create()
        alert?.show()
    }
}
