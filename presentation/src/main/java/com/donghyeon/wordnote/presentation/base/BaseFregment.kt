package com.donghyeon.wordnote.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutRes: Int
) : Fragment() {

    companion object {
        private var toast: Toast? = null
    }

    protected lateinit var binding: VDB
    abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate<VDB>(inflater, layoutRes, container, false).apply {
            lifecycleOwner = this@BaseFragment
        }
        viewModel.message.observe(viewLifecycleOwner) {
            showToast(it)
        }
        return binding.root
    }

    private fun showToast(
        message: String
    ) {
        toast?.cancel()
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast?.setText(message)
        toast?.show()
    }
}
