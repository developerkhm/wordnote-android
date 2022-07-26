package com.donghyeon.wordnote.presentation.note

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseActivity
import com.donghyeon.wordnote.presentation.databinding.ActivityNoteEditBinding
import com.donghyeon.wordnote.presentation.utils.LinearDecoration
import com.donghyeon.wordnote.presentation.utils.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteEditActivity : BaseActivity<ActivityNoteEditBinding, NoteEditViewModel>(
    R.layout.activity_note_edit
) {

    override val viewModel by viewModels<NoteEditViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            vm = viewModel
            rvNote.adapter = NoteEditAdapter(viewModel)
            rvNote.addItemDecoration(LinearDecoration(15.dp))
            setSupportActionBar(tbTitle)
        }
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
