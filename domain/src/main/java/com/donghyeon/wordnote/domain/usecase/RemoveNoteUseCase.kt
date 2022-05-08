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
        if (repository.getNoteList().count() <= 1) {
            emit("단어장이 이거 하나 밖에 없습니다")
        } else {
            repository.removeNote(noteData)
            repository.getNoteList().let {
                if (noteData.id == repository.getSelectedNoteId()) {
                    repository.setSelectedNoteId(it.first().id)
                }
                emit(it)
            }
        }
    }.flowOn(IO)
}
