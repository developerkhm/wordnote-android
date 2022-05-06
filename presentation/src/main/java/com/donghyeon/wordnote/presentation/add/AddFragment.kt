package com.donghyeon.wordnote.presentation.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.add.note.NoteFragment
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
                is AddState.ShowMessage -> showToast(it.message)
                is AddState.AddComplete -> {
                    binding.etWord.setText("")
                    binding.etDescription.setText("")
                }
                is AddState.SelectedNote -> {
                    val noteFragment = NoteFragment()
                    noteFragment.show(requireActivity().supportFragmentManager, noteFragment.tag)
                }
            }
        }
        viewModel.getNote()
    }
}
