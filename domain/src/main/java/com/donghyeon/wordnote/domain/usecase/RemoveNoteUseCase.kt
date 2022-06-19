package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.Repository
import com.donghyeon.wordnote.domain.model.NoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoveNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(noteData: NoteData) = flow {
        if (repository.getNoteList().count() <= 1) {
            emit("단어장이 이거 하나 밖에 없습니다")
        } else {
            repository.removeNote(noteData)
            repository.getNoteList().let {
                if (noteData.id == repository.getNoteId().first()) {
                    repository.setNoteId(it.first().id).first()
                }
                emit(it)
            }
        }
    }.flowOn(Dispatchers.IO)
}
