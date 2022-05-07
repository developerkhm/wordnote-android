package com.donghyeon.wordnote.presentation.note

import android.os.Bundle
import androidx.activity.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseActivity
import com.donghyeon.wordnote.presentation.databinding.ActivityNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteActivity : BaseActivity<ActivityNoteBinding, NoteViewModel>(
    R.layout.activity_note
) {

    override val viewModel by viewModels<NoteViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
    }
}
