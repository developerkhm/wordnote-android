package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetNoteUseCase(
    private val repository: Repository
) {

    operator fun invoke() = flow {
        if (repository.getNoteList().count() == 0)
            repository.addNote("나의 단어장")
        val noteList = repository.getNoteList()
        repository.getSelectedNoteId()?.let { id ->
            val note = noteList.find { it.id == id }
            if (note != null) {
                emit(note)
                return@flow
            }
        }
        repository.setSelectedNoteId(noteList.first().id)
        emit(noteList.first())
    }.flowOn(IO)
}
