package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetItemListUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() = flow {
        val noteId = repository.getNoteId().first()
        if (noteId == 0L) {
            emit(listOf())
            return@flow
        }
        emit(repository.getItemList(noteId))
    }.flowOn(Dispatchers.IO)
}
