package com.donghyeon.wordnote.presentation.note

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseActivity
import com.donghyeon.wordnote.presentation.databinding.ActivityNoteEditBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteEditActivity : BaseActivity<ActivityNoteEditBinding, NoteEditViewModel>(
    R.layout.activity_note_edit
) {

    override val viewModel by viewModels<NoteEditViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.rvNote.adapter = NoteEditAdapter(viewModel)
        viewModel.noteEditState.observe(this) {
            when (it) {
                is NoteEditState.ShowMessage -> showToast(it.message)
            }
        }
        setSupportActionBar(binding.tbTitle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNoteList()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
