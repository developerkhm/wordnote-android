package com.donghyeon.wordnote.data.service.datastore

interface DataStoreService {

    suspend fun setSelectedNoteId(noteId: Long): Long

    suspend fun getSelectedNoteId(): Long?
}
