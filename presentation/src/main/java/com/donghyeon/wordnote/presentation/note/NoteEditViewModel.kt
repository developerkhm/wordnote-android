package com.donghyeon.wordnote.presentation.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.usecase.AddNoteUseCase
import com.donghyeon.wordnote.domain.usecase.GetNoteListUseCase
import com.donghyeon.wordnote.domain.usecase.RemoveNoteUseCase
import com.donghyeon.wordnote.presentation.base.BaseState
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteEditViewModel @Inject constructor(
    private val getNoteListUseCase: GetNoteListUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val removeNoteUseCase: RemoveNoteUseCase
) : BaseViewModel() {

    private val _noteDataList = MutableLiveData<List<NoteData>>()
    val noteDataList: LiveData<List<NoteData>> = _noteDataList

    private val _noteEditState = MutableLiveData<NoteEditState>()
    val noteEditState: LiveData<NoteEditState> = _noteEditState

    val note = MutableLiveData<String>()

    fun getNoteList() {
        viewModelScope.launch {
            getNoteListUseCase().collect {
                _noteDataList.value = it
            }
        }
    }

    fun addNote() {
        viewModelScope.launch {
            addNoteUseCase(note.value).collect {
                when (it) {
                    is String -> _baseState.value = BaseState.ShowMessage(it)
                    is Boolean -> {
                        note.value = ""
                        getNoteList()
                    }
                }
            }
        }
    }

    fun removeNote(noteData: NoteData) {
        viewModelScope.launch {
            removeNoteUseCase(noteData).collect {
                when (it) {
                    is String -> _baseState.value = BaseState.ShowMessage(it)
                    is List<*> -> _noteDataList.value = it.map { noteData ->
                        noteData as NoteData
                    }
                }
            }
        }
    }
}
