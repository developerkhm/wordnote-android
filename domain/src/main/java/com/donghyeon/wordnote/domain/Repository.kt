package com.donghyeon.wordnote.domain

import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.model.NoteData
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun addNote(note: String)

    suspend fun getNoteList(): List<NoteData>

    suspend fun removeNote(noteData: NoteData)

    suspend fun setNoteId(noteId: Long): Flow<Unit>

    suspend fun getNoteId(): Flow<Long>

    suspend fun addItem(noteId: Long, word: String, description: String)

    suspend fun getItemList(noteId: Long): List<ItemData>

    suspend fun removeItem(itemData: ItemData)
}
