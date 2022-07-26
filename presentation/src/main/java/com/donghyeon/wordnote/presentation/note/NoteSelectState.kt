package com.donghyeon.wordnote.presentation.note

import com.donghyeon.wordnote.domain.model.NoteData

sealed class NoteSelectState {

    data class SelectedNote(
        val noteData: NoteData
    ) : NoteSelectState()
    object EditNote : NoteSelectState()
}
