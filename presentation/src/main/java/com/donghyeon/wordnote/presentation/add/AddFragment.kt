package com.donghyeon.wordnote.presentation.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.add.note.NoteSelectFragment
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding, AddViewModel>(
    R.layout.fragment_add
) {

    override val viewModel by viewModels<AddViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        viewModel.addState.observe(viewLifecycleOwner) {
            when (it) {
                is AddState.ShowMessage -> showToast(it.message)
                is AddState.SelectedNote -> {
                    NoteSelectFragment().let { fragment ->
                        fragment.showNoteFragment(
                            requireActivity().supportFragmentManager,
                            fragment.tag
                        ) { noteData ->
                            viewModel.setNote(noteData)
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNote()
    }
}
