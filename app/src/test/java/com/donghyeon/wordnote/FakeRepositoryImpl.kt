package com.donghyeon.wordnote

import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.repository.Repository

class FakeRepositoryImpl : Repository {

    override suspend fun addNote(note: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteList(): List<NoteData> {
        return listOf(
            NoteData(1, "나의 단어장"),
            NoteData(2, "너의 단어장")
        )
    }

    override suspend fun removeNote(noteData: NoteData) {
        TODO("Not yet implemented")
    }

    override suspend fun setSelectedNoteId(noteId: Long): Long {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedNoteId(): Long = 1

    override suspend fun addItem(noteId: Long, word: String, description: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getItemList(noteId: Long): List<ItemData> {
        TODO("Not yet implemented")
    }

    override suspend fun removeItem(itemData: ItemData) {
        TODO("Not yet implemented")
    }
}
