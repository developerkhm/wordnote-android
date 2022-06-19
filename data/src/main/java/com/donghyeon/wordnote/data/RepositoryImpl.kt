package com.donghyeon.wordnote.data

import com.donghyeon.wordnote.data.service.room.model.Item
import com.donghyeon.wordnote.data.service.room.model.Note
import com.donghyeon.wordnote.data.source.LocalDataSource
import com.donghyeon.wordnote.domain.Repository
import com.donghyeon.wordnote.domain.dispatcher.Dispatcher
import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.model.NoteData
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dispatcher: Dispatcher,
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun addNote(note: String) =
        localDataSource.addNote(Note(note))

    override suspend fun getNoteList() =
        Mapper.noteList(localDataSource.getNoteList())

    override suspend fun removeNote(noteData: NoteData) =
        localDataSource.removeNote(Note(noteData.id, noteData.note))

    override suspend fun setNoteId(noteId: Long) = flow {
        emit(localDataSource.setNoteId(noteId))
    }.flowOn(dispatcher.io)

    override suspend fun getNoteId() = flow {
        emit(localDataSource.getNoteId())
    }.flowOn(dispatcher.io)

    override suspend fun addItem(noteId: Long, word: String, description: String) =
        localDataSource.addItem(Item(noteId, word, description))

    override suspend fun getItemList(noteId: Long) =
        Mapper.itemList(localDataSource.getItemList(noteId))

    override suspend fun removeItem(itemData: ItemData) =
        localDataSource.removeItem(
            Item(itemData.id, itemData.noteId, itemData.word, itemData.description)
        )
}
