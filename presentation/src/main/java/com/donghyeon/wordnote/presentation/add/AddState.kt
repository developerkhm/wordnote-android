package com.donghyeon.wordnote.presentation.add

sealed class AddState {

    object InputCheck : AddState()
    object Complete : AddState()
    object Failed : AddState()
}
