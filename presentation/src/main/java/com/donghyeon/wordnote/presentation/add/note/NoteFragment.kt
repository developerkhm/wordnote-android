package com.donghyeon.wordnote.presentation.add.note

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.databinding.FragmentNoteBinding
import com.donghyeon.wordnote.presentation.note.NoteActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : DialogFragment() {

    private lateinit var binding: FragmentNoteBinding
    private val viewModel by viewModels<NoteViewModel>()

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
        viewModel.noteState.observe(this) {
            when (it) {
                is NoteState.EditNote ->
                    startActivity(Intent(context, NoteActivity::class.java))
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNoteList()
    }
}
