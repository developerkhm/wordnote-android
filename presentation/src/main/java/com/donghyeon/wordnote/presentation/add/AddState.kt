package com.donghyeon.wordnote.presentation.add

sealed class AddState {

    object None : AddState()
    object InputCheck : AddState()
    object Complete : AddState()
    object Failed : AddState()
}
