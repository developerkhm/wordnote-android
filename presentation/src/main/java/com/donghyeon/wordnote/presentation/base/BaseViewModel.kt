package com.donghyeon.wordnote.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected val _baseState = MutableLiveData<BaseState>()
    val baseState: LiveData<BaseState> = _baseState

    protected val ceh = CoroutineExceptionHandler { _, throwable ->
        viewModelScope.launch {
            _baseState.value =
                BaseState.ShowMessage(throwable.message.toString())
        }
    }
}
