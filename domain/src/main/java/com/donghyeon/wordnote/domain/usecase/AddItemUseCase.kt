package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AddItemUseCase(
    private val repository: Repository
) {

    operator fun invoke(
        noteId: Long,
        word: String,
        description: String
    ) = flow {
        repository.addItem(noteId, word, description)
        emit(true)
    }.flowOn(IO)
}
