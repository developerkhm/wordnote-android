package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetNoteListUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() = flow {
        emit(repository.getNoteList())
    }.flowOn(Dispatchers.IO)
}
