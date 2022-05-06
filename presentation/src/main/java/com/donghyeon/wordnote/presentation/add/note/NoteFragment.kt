package com.donghyeon.wordnote.presentation.add.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.databinding.FragmentNoteBinding

class NoteFragment : DialogFragment() {

    private lateinit var binding: FragmentNoteBinding
    private val viewModel by activityViewModels<NoteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate<FragmentNoteBinding>(
            inflater,
            R.layout.fragment_note,
            container,
            false
        ).apply {
            lifecycleOwner = this@NoteFragment
            vm = viewModel
            rvNote.adapter = NoteAdapter(viewModel)
        }
        viewModel.getNoteList()
        return binding.root
    }
}
