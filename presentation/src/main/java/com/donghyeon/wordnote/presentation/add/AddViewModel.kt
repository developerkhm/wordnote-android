package com.donghyeon.wordnote.presentation.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.donghyeon.wordnote.domain.usecase.ItemUseCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val itemUseCase: ItemUseCase
) : BaseViewModel() {

    val addModel = MutableLiveData(AddModel())

    private val _addState = MutableLiveData<AddState>()
    val addState: LiveData<AddState> = _addState

    fun getNote() {
        viewModelScope.launch {
            itemUseCase.getNote().collect {
                addModel.value = AddModel(noteId = it.id, note = it.note)
            }
        }
    }

    fun addItem() {
        viewModelScope.launch {
            addModel.value?.let { addModel ->
                if (addModel.word != "" && addModel.description != "") {
                    itemUseCase.addItem(
                        addModel.noteId,
                        addModel.word,
                        addModel.description
                    ).collect { result ->
                        _addState.value = if (result) AddState.Complete else AddState.Failed
                    }
                } else _addState.value = AddState.InputCheck
            }
        }
    }
}
