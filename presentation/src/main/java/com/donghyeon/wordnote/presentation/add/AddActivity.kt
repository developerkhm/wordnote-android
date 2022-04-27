package com.donghyeon.wordnote.presentation.add

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseActivity
import com.donghyeon.wordnote.presentation.databinding.ActivityAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddActivity : BaseActivity<ActivityAddBinding, AddViewModel>(
    R.layout.activity_add
) {

    override val viewModel by viewModels<AddViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        setSupportActionBar(binding.tbTitle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setObserver()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    private fun setObserver() {
        viewModel.addState.observe(this) {
            when (it) {
                AddState.Complete -> finish()
                AddState.Failed -> showToast(getString(R.string.toast_add_failed))
                AddState.InputCheck -> showToast(getString(R.string.toast_input_check))
            }
        }
    }
}
