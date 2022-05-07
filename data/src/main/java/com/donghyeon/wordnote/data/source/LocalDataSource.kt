package com.donghyeon.wordnote.data.source

import com.donghyeon.wordnote.data.service.room.Item
import com.donghyeon.wordnote.data.service.room.Note

interface LocalDataSource {

    suspend fun addNote(note: Note)

    suspend fun getNoteList(): List<Note>

    suspend fun removeNote(note: Note)

    suspend fun setSelectedNoteId(noteId: Long): Long

    suspend fun getSelectedNoteId(): Long?

    suspend fun addItem(item: Item)

    suspend fun getItemList(noteId: Long): List<Item>

    suspend fun removeItem(item: Item)
}
