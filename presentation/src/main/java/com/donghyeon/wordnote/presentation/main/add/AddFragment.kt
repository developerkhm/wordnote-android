package com.donghyeon.wordnote.presentation.main.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentAddBinding
import com.donghyeon.wordnote.presentation.note.NoteSelectFragment
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
                is AddState.SelectedNote -> {
                    NoteSelectFragment(true).let { fragment ->
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
