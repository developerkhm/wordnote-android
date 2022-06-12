package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() = flow {
        if (repository.getNoteList().isEmpty())
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
    }
}
