package com.donghyeon.wordnote.presentation.read

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentReadBinding

class ReadFragment : BaseFragment<FragmentReadBinding, ReadViewModel>(
    R.layout.fragment_read
) {

    override val viewModel by activityViewModels<ReadViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.rvList.adapter = ReadAdapter(viewModel)
        viewModel.getItemAll()
    }
}
