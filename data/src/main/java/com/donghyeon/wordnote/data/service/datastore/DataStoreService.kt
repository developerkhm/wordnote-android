package com.donghyeon.wordnote.data.service.datastore

interface DataStoreService {

    suspend fun setNoteId(noteId: Long)

    suspend fun getNoteId(): Long
}
