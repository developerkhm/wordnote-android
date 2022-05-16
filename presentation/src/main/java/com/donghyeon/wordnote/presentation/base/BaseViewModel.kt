package com.donghyeon.wordnote.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message
}
