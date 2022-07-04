package com.donghyeon.wordnote.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.donghyeon.wordnote.domain.usecase.AppLoadCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appLoadCase: AppLoadCase
) : BaseViewModel() {

    private val _isComplete = MutableLiveData(false)
    val isComplete: LiveData<Boolean> = _isComplete

    init {
        viewModelScope.launch {
            _isComplete.value = appLoadCase()
        }
    }
}
