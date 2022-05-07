package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoveNoteUseCase(
    private val repository: Repository
) {

    operator fun invoke(noteData: NoteData) = flow {
        repository.removeNote(noteData)
        emit(repository.getNoteList())
    }.flowOn(IO)
}
