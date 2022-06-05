package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.dispatcher.Dispatcher
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoveNoteUseCase @Inject constructor(
    private val dispatcher: Dispatcher,
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
    }.flowOn(dispatcher.io)
}
