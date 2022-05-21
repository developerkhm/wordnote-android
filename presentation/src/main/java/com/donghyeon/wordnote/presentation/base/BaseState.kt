package com.donghyeon.wordnote.presentation.base

sealed class BaseState {

    data class ShowMessage(
        val message: String
    ) : BaseState()

    object KeyboardHide : BaseState()
}
