package com.donghyeon.wordnote.presentation.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentAddBinding

class AddFragment : BaseFragment<FragmentAddBinding, AddViewModel>(
    R.layout.fragment_add
) {

    override val viewModel by activityViewModels<AddViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        viewModel.addState.observe(viewLifecycleOwner) {
            when (it) {
                is AddState.InputCheck -> showToast(getString(R.string.toast_input_check))
                is AddState.Failed -> showToast(getString(R.string.toast_add_failed))
                is AddState.Complete -> {
                    binding.etWord.setText("")
                    binding.etDescription.setText("")
                    showToast(getString(R.string.toast_add_complete))
                }
            }
        }
        viewModel.getNote()
    }
}
