package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ItemUseCase(
    private val repository: Repository
) {

    fun addNote(note: String): Flow<Boolean> {
        return flow {
            repository.addNote(note)
            emit(true)
        }.flowOn(IO)
    }

    fun getNote(): Flow<NoteData> {
        return flow {
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

    fun addItem(noteId: Long, word: String, description: String): Flow<Boolean> {
        return flow {
            repository.addItem(noteId, word, description)
            emit(true)
        }.flowOn(IO)
    }

    fun getItemList(): Flow<List<ItemData>> {
        return flow {
            repository.getSelectedNoteId()?.let {
                emit(repository.getItemList(it))
                return@flow
            }
            emit(listOf())
        }.flowOn(IO)
    }

    fun removeItem(itemData: ItemData): Flow<List<ItemData>> {
        return flow {
            repository.removeItem(itemData)
            emit(repository.getItemList(itemData.noteId))
        }.flowOn(IO)
    }
}
