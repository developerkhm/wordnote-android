package com.donghyeon.wordnote.presentation.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.usecase.GetNoteListUseCase
import com.donghyeon.wordnote.domain.usecase.SelectedNoteUseCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteSelectViewModel @Inject constructor(
    private val getNoteListUseCase: GetNoteListUseCase,
    private val selectedNoteUseCase: SelectedNoteUseCase
) : BaseViewModel() {

    private val _noteDataList = MutableLiveData<List<NoteData>>()
    val noteDataList: LiveData<List<NoteData>> = _noteDataList

    private val _noteSelectState = MutableLiveData<NoteSelectState>()
    val noteSelectState: LiveData<NoteSelectState> = _noteSelectState

    fun getNoteList() {
        viewModelScope.launch(ceh) {
            getNoteListUseCase().collect {
                _noteDataList.value = it
            }
        }
    }

    fun selectedNote(noteData: NoteData) {
        viewModelScope.launch(ceh) {
            selectedNoteUseCase(noteData).collect {
                _noteSelectState.value = NoteSelectState.SelectedNote(noteData)
            }
        }
    }

    fun editNote() {
        _noteSelectState.value = NoteSelectState.EditNote
    }
}
