package com.donghyeon.wordnote.presentation.read

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentReadBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReadFragment : BaseFragment<FragmentReadBinding, ReadViewModel>(
    R.layout.fragment_read
) {

    override val viewModel by viewModels<ReadViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.rvList.adapter = ReadAdapter(viewModel)
        viewModel.getItemList()
    }
}
