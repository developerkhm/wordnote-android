package com.donghyeon.wordnote.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.donghyeon.wordnote.domain.usecase.ItemUseCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemUseCase: ItemUseCase
) : BaseViewModel() {

    private val _mainState = MutableLiveData<MainState>()
    val mainState: LiveData<MainState> = _mainState

    fun add() {
        _mainState.value = MainState.Add
    }

    fun setting() {
        _mainState.value = MainState.Setting
    }
}
