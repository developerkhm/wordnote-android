package com.donghyeon.wordnote.domain.repository

import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.model.NoteData

interface Repository {

    suspend fun addNote(note: String)

    suspend fun getNoteList(): List<NoteData>

    suspend fun setSelectedNoteId(noteId: Long): Long

    suspend fun getSelectedNoteId(): Long?

    suspend fun addItem(noteId: Long, word: String, description: String)

    suspend fun getItemList(noteId: Long): List<ItemData>

    suspend fun removeItem(itemData: ItemData)
}
