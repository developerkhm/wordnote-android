package com.donghyeon.wordnote.presentation.read

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.usecase.ItemUseCase
import com.donghyeon.wordnote.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReadViewModel @Inject constructor(
    private val itemUseCase: ItemUseCase
) : BaseViewModel() {

    private val _itemDataList = MutableLiveData<List<ItemData>>()
    val itemDataList: LiveData<List<ItemData>> = _itemDataList

    val diffUtil = object : DiffUtil.ItemCallback<ItemData>() {
        override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem.word == newItem.word
        }
        override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem.word == newItem.word &&
                oldItem.description == newItem.description
        }
    }

    fun getItemAll() {
        viewModelScope.launch {
            itemUseCase.getItemAll().collect {
                _itemDataList.value = it
            }
        }
    }

    fun selectedItem(itemData: ItemData) {}

    fun removeItem(itemData: ItemData) {
        viewModelScope.launch {
            itemUseCase.removeItem(itemData).collect {
                _itemDataList.value = it
            }
        }
    }
}
