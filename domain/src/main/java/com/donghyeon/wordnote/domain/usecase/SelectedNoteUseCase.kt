package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SelectedNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(noteData: NoteData) = flow {
        repository.setSelectedNoteId(noteData.id)
        emit(true)
    }
}
