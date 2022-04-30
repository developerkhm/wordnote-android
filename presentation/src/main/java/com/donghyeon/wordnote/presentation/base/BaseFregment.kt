package com.donghyeon.wordnote.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutRes: Int
) : Fragment() {

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
        return binding.root
    }
}
