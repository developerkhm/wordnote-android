package com.donghyeon.wordnote.presentation.main.add

sealed class AddState {

    data class ShowMessage(
        val message: String
    ) : AddState()
    object SelectedNote : AddState()
}
