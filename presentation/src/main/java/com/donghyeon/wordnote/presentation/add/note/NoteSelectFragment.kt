package com.donghyeon.wordnote.presentation.add.note

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.databinding.FragmentNoteSelectBinding
import com.donghyeon.wordnote.presentation.note.NoteEditActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteSelectFragment : DialogFragment() {

    private lateinit var binding: FragmentNoteSelectBinding
    private val viewModel by viewModels<NoteSelectViewModel>()
    private var noteCallback: ((NoteData) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate<FragmentNoteSelectBinding>(
            inflater,
            R.layout.fragment_note_select,
            container,
            false
        ).apply {
            lifecycleOwner = this@NoteSelectFragment
            vm = viewModel
            rvNote.adapter = NoteSelectAdapter(viewModel)
        }
        viewModel.noteSelectState.observe(this) {
            when (it) {
                is NoteSelectState.EditNote ->
                    startActivity(Intent(context, NoteEditActivity::class.java))
                is NoteSelectState.SelectedNote -> {
                    noteCallback?.invoke(it.noteData)
                    this@NoteSelectFragment.dismiss()
                }
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNoteList()
    }

    fun showNoteFragment(
        manager: FragmentManager,
        tag: String?,
        noteCallback: (NoteData) -> Unit
    ) {
        this.noteCallback = noteCallback
        show(manager, tag)
    }
}