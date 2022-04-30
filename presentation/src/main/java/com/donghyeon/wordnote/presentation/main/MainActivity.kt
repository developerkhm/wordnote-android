package com.donghyeon.wordnote.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.add.AddFragment
import com.donghyeon.wordnote.presentation.base.BaseActivity
import com.donghyeon.wordnote.presentation.databinding.ActivityMainBinding
import com.donghyeon.wordnote.presentation.quiz.QuizFragment
import com.donghyeon.wordnote.presentation.read.ReadFragment
import com.donghyeon.wordnote.presentation.setting.SettingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    override val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val addFragment: AddFragment by lazy { AddFragment() }
        val readFragment: ReadFragment by lazy { ReadFragment() }
        val quizFragment: QuizFragment by lazy { QuizFragment() }
        val settingFragment: SettingFragment by lazy { SettingFragment() }
        binding.bnvMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.m_add -> { setFragment(addFragment) }
                R.id.m_read -> { setFragment(readFragment) }
                R.id.m_quiz -> { setFragment(quizFragment) }
                R.id.m_setting -> { setFragment(settingFragment) }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_container, fragment, null).commit()
    }
}
