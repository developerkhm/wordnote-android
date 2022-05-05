package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetItemListUseCase(
    private val repository: Repository
) {

    operator fun invoke() = flow {
        repository.getSelectedNoteId()?.let {
            emit(repository.getItemList(it))
            return@flow
        }
        emit(listOf())
    }.flowOn(IO)
}
