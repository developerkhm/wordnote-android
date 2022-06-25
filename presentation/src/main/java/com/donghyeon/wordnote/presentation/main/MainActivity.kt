package com.donghyeon.wordnote.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseActivity
import com.donghyeon.wordnote.presentation.databinding.ActivityMainBinding
import com.donghyeon.wordnote.presentation.main.add.AddFragment
import com.donghyeon.wordnote.presentation.main.quiz.QuizFragment
import com.donghyeon.wordnote.presentation.main.read.ReadFragment
import com.donghyeon.wordnote.presentation.main.setting.SettingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    override val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isComplete.collect {
                    if (it) initView()
                }
            }
        }
    }

    private fun initView() {
        with(binding) {
            bnvMenu.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.m_add -> { setFragment(AddFragment()) }
                    R.id.m_read -> { setFragment(ReadFragment()) }
                    R.id.m_quiz -> { setFragment(QuizFragment()) }
                    R.id.m_setting -> { setFragment(SettingFragment()) }
                }
                return@setOnItemSelectedListener true
            }
            bnvMenu.selectedItemId = R.id.m_read
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_container, fragment, null).commit()
    }
}
