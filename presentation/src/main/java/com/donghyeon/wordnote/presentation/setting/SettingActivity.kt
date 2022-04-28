package com.donghyeon.wordnote.presentation.setting

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseActivity
import com.donghyeon.wordnote.presentation.databinding.ActivitySettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingActivity : BaseActivity<ActivitySettingBinding, SettingViewModel>(
    R.layout.activity_setting
) {

    override val viewModel by viewModels<SettingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        setSupportActionBar(binding.tbTitle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val version = "v"+ packageManager.getPackageInfo(packageName, 0).versionName
        binding.tvVersion.text = version
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
