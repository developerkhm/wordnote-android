package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() = flow {
        if (repository.getNoteList().isEmpty())
            repository.addNote("나의 단어장")
        val noteList = repository.getNoteList()
        var noteId = repository.getNoteId().first()
        if (noteId == 0L) {
            noteId = noteList.first().id
            repository.setNoteId(noteId).first()
            emit(noteList.first())
            return@flow
        }
        noteList.find { it.id == noteId }?.let {
            emit(it)
        }
    }.flowOn(Dispatchers.IO)
}
