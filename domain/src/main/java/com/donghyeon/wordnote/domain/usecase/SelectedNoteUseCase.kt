package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.dispatcher.Dispatcher
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SelectedNoteUseCase @Inject constructor(
    private val dispatcher: Dispatcher,
    private val repository: Repository
) {

    operator fun invoke(noteData: NoteData) = flow {
        repository.setSelectedNoteId(noteData.id)
        emit(true)
    }.flowOn(dispatcher.io)
}
