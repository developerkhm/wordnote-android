package com.donghyeon.wordnote.presentation.add.note

sealed class NoteState {

    object None : NoteState()
    object EditNote : NoteState()
}
