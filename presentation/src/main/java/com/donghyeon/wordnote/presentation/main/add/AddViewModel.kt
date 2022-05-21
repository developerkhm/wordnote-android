package com.donghyeon.wordnote.presentation.main.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.usecase.AddItemUseCase
import com.donghyeon.wordnote.domain.usecase.GetNoteUseCase
import com.donghyeon.wordnote.presentation.base.BaseState
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

    private val _addState = MutableLiveData<AddState>()
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
                addItemUseCase(
                    addModel.noteId,
                    addModel.word,
                    addModel.description
                ).collect { result ->
                    when (result) {
                        is String -> _baseState.value = BaseState.ShowMessage(result)
                        is Boolean -> this@AddViewModel.addModel.value?.let {
                            it.word = ""
                            it.description = ""
                            this@AddViewModel.addModel.value = it
                        }
                    }
                }
            }
        }
    }

    fun selectedNote() {
        _addState.value = AddState.SelectedNote
    }

    fun setNote(noteData: NoteData) {
        addModel.value?.let {
            it.noteId = noteData.id
            it.note = noteData.note
            addModel.value = it
        }
    }
}
