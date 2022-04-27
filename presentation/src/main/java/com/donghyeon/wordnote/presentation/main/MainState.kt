package com.donghyeon.wordnote.presentation.main

sealed class MainState {

    object Add : MainState()
    object Setting : MainState()
}
