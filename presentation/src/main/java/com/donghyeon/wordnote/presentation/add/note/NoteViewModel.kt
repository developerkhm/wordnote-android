package com.donghyeon.wordnote.presentation.add.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.usecase.GetNoteListUseCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNoteListUseCase: GetNoteListUseCase
) : BaseViewModel() {

    private val _noteDataList = MutableLiveData<List<NoteData>>()
    val noteDataList: LiveData<List<NoteData>> = _noteDataList

    val diffUtil = object : DiffUtil.ItemCallback<NoteData>() {
        override fun areItemsTheSame(oldItem: NoteData, newItem: NoteData): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: NoteData, newItem: NoteData): Boolean {
            return oldItem.id == newItem.id &&
                oldItem.note == newItem.note
        }
    }

    fun getNoteList() {
        viewModelScope.launch {
            getNoteListUseCase().collect {
                _noteDataList.value = it
            }
        }
    }

    fun selectedNote(noteData: NoteData) {}
}