package com.donghyeon.wordnote.presentation.note

import android.os.Bundle
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
    }
}
