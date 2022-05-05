package com.donghyeon.wordnote.presentation.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.donghyeon.wordnote.domain.usecase.AddItemUseCase
import com.donghyeon.wordnote.domain.usecase.GetNoteUseCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val getNoteUseCase: GetNoteUseCase,
    private val addItemUseCase: AddItemUseCase
) : BaseViewModel() {

    val addModel = MutableLiveData(AddModel())

    private val _addState = MutableLiveData<AddState>(AddState.None)
    val addState: LiveData<AddState> = _addState

    fun getNote() {
        viewModelScope.launch {
            getNoteUseCase().collect {
                addModel.value = AddModel(noteId = it.id, note = it.note)
            }
        }
    }

    fun addItem() {
        viewModelScope.launch {
            addModel.value?.let { addModel ->
                if (addModel.word != "" && addModel.description != "") {
                    addItemUseCase(
                        addModel.noteId,
                        addModel.word,
                        addModel.description
                    ).collect { result ->
                        if (result) {
                            _addState.value = AddState.Complete
                            _addState.value = AddState.None
                        } else _addState.value = AddState.Failed
                    }
                } else _addState.value = AddState.InputCheck
            }
        }
    }
}
