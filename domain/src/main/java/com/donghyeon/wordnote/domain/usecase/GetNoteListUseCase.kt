package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetNoteListUseCase(
    private val repository: Repository
) {

    operator fun invoke() = flow {
        emit(repository.getNoteList())
    }.flowOn(IO)
}
