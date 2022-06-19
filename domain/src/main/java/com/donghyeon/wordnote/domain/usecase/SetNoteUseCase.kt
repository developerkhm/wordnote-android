package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.Repository
import com.donghyeon.wordnote.domain.model.NoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SetNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(noteData: NoteData) = flow {
        repository.setNoteId(noteData.id).first()
        emit(true)
    }.flowOn(Dispatchers.IO)
}
