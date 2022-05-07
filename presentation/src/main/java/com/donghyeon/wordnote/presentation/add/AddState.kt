package com.donghyeon.wordnote.presentation.add

sealed class AddState {

    data class ShowMessage(
        val message: String
    ) : AddState()
    object SelectedNote : AddState()
}
