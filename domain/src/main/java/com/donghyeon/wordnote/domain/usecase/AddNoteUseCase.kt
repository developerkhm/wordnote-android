package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(note: String?) = flow {
        if (note.isNullOrEmpty()) emit("단어장 이름을 입력하세요")
        else {
            repository.addNote(note)
            emit(true)
        }
    }.flowOn(Dispatchers.IO)
}
