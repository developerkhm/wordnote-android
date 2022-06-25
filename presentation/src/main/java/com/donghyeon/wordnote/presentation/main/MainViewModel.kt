package com.donghyeon.wordnote.presentation.main

import androidx.lifecycle.viewModelScope
import com.donghyeon.wordnote.domain.usecase.AppLoadCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appLoadCase: AppLoadCase
) : BaseViewModel() {

    private val _isComplete = MutableStateFlow(false)
    val isComplete: StateFlow<Boolean> = _isComplete

    init {
        viewModelScope.launch {
            appLoadCase()
            _isComplete.value = true
        }
    }
}
