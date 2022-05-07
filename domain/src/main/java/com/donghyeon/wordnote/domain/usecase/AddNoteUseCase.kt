package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AddNoteUseCase(
    private val repository: Repository
) {

    operator fun invoke(note: String?) = flow {
        if (note.isNullOrEmpty()) emit("단어장 이름을 입력하세요")
        else {
            repository.addNote(note)
            emit(true)
        }
    }.flowOn(IO)
}
