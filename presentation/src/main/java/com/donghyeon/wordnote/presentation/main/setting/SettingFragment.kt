package com.donghyeon.wordnote.presentation.main.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>(
    R.layout.fragment_setting
) {

    override val viewModel by viewModels<SettingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        context?.let {
            val version = "v" + it.packageManager.getPackageInfo(it.packageName, 0).versionName
            binding.tvVersion.text = version
        }
    }
}
