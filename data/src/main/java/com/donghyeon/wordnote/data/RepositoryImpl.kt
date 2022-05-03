package com.donghyeon.wordnote.data

import com.donghyeon.wordnote.data.service.room.Item
import com.donghyeon.wordnote.data.service.room.Note
import com.donghyeon.wordnote.data.source.LocalDataSource
import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun addNote(note: String) =
        localDataSource.addNote(Note(note))

    override suspend fun getNoteList() =
        localDataSource.getNoteList().map {
            NoteData(it.id, it.note)
        }

    override suspend fun setSelectedNoteId(noteId: Long) =
        localDataSource.setSelectedNoteId(noteId)

    override suspend fun getSelectedNoteId() =
        localDataSource.getSelectedNoteId()

    override suspend fun addItem(noteId: Long, word: String, description: String) =
        localDataSource.addItem(Item(noteId, word, description))

    override suspend fun getItemList(noteId: Long) =
        localDataSource.getItemList(noteId).map {
            ItemData(it.id, it.noteId, it.word, it.description)
        }

    override suspend fun removeItem(itemData: ItemData) =
        localDataSource.removeItem(
            Item(itemData.id, itemData.noteId, itemData.word, itemData.description)
        )
}
