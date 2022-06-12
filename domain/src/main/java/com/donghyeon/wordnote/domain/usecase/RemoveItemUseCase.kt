package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoveItemUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(itemData: ItemData) = flow {
        repository.removeItem(itemData)
        emit(repository.getItemList(itemData.noteId))
    }.flowOn(Dispatchers.IO)
}
