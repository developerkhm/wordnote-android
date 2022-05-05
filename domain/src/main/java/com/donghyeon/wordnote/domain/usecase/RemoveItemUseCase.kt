package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoveItemUseCase(
    private val repository: Repository
) {

    operator fun invoke(itemData: ItemData) = flow {
        repository.removeItem(itemData)
        emit(repository.getItemList(itemData.noteId))
    }.flowOn(IO)
}
