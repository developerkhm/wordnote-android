package com.donghyeon.wordnote.data.source

import com.donghyeon.wordnote.data.service.room.model.Item
import com.donghyeon.wordnote.data.service.room.model.Note

interface LocalDataSource {

    suspend fun addNote(note: Note)

    suspend fun getNoteList(): List<Note>

    suspend fun removeNote(note: Note)

    suspend fun setNoteId(noteId: Long)

    suspend fun getNoteId(): Long

    suspend fun addItem(item: Item)

    suspend fun getItemList(noteId: Long): List<Item>

    suspend fun removeItem(item: Item)
}
