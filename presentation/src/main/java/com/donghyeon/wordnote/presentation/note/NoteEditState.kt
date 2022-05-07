package com.donghyeon.wordnote.presentation.note

sealed class NoteEditState {

    data class ShowMessage(
        val message: String
    ) : NoteEditState()
}
