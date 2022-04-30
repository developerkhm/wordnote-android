package com.donghyeon.wordnote.presentation.add

sealed class AddState {

    data class Note(
        val note: String
    ) : AddState()
    object InputCheck : AddState()
    object Complete : AddState()
    object Failed : AddState()
}
