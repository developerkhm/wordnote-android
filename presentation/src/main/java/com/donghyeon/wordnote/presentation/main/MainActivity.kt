package com.donghyeon.wordnote.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.add.AddActivity
import com.donghyeon.wordnote.presentation.base.BaseActivity
import com.donghyeon.wordnote.presentation.databinding.ActivityMainBinding
import com.donghyeon.wordnote.presentation.setting.SettingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    override val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.rvList.adapter = MainAdapter(viewModel)
        setSupportActionBar(binding.tbTitle)
        viewModel.mainState.observe(this) {
            when (it) {
                MainState.Add ->
                    startActivity(Intent(this, AddActivity::class.java))
                MainState.Setting ->
                    startActivity(Intent(this, SettingActivity::class.java))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getItemAll()
    }
}
