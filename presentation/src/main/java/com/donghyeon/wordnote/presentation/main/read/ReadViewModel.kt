package com.donghyeon.wordnote.presentation.main.read

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.usecase.GetItemListUseCase
import com.donghyeon.wordnote.domain.usecase.GetSelectedNoteUseCase
import com.donghyeon.wordnote.domain.usecase.RemoveItemUseCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReadViewModel @Inject constructor(
    private val getSelectedNoteUseCase: GetSelectedNoteUseCase,
    private val getItemListUseCase: GetItemListUseCase,
    private val removeItemUseCase: RemoveItemUseCase
) : BaseViewModel() {

    private val _noteData = MutableLiveData<NoteData>()
    val noteData: LiveData<NoteData> = _noteData

    private val _itemDataList = MutableLiveData<List<ItemData>>()
    val itemDataList: LiveData<List<ItemData>> = _itemDataList

    val diffUtil = object : DiffUtil.ItemCallback<ItemData>() {
        override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem.id == newItem.id &&
                oldItem.word == newItem.word
        }
    }

    fun getSelectedNote() {
        viewModelScope.launch {
            getSelectedNoteUseCase().collect {
                _noteData.value = it
            }
        }
    }

    fun getItemList() {
        viewModelScope.launch {
            getItemListUseCase().collect {
                _itemDataList.value = it
            }
        }
    }

    fun selectedItem(itemData: ItemData) {}

    fun removeItem(itemData: ItemData) {
        viewModelScope.launch {
            removeItemUseCase(itemData).collect {
                _itemDataList.value = it
            }
        }
    }
}
