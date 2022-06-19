package com.donghyeon.wordnote.data.source

import com.donghyeon.wordnote.data.service.datastore.DataStoreService
import com.donghyeon.wordnote.data.service.room.RoomService
import com.donghyeon.wordnote.data.service.room.model.Item
import com.donghyeon.wordnote.data.service.room.model.Note
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dataStoreService: DataStoreService,
    private val roomService: RoomService
) : LocalDataSource {

    override suspend fun addItem(item: Item) =
        roomService.dao().addItem(item)

    override suspend fun addNote(note: Note) =
        roomService.dao().addNote(note)

    override suspend fun getNoteList() =
        roomService.dao().getNoteList()

    override suspend fun removeNote(note: Note) {
        roomService.dao().removeNote(note)
        roomService.dao().removeItem(note.id)
    }

    override suspend fun setNoteId(noteId: Long) =
        dataStoreService.setNoteId(noteId)

    override suspend fun getNoteId() =
        dataStoreService.getNoteId()

    override suspend fun getItemList(noteId: Long) =
        roomService.dao().getItemList(noteId)

    override suspend fun removeItem(item: Item) =
        roomService.dao().removeItem(item)
}
