package com.donghyeon.wordnote.data.service.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreService @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    companion object DataStoreKey {
        val NOTE_ID = longPreferencesKey("NOTE_ID")
    }

    suspend fun setNoteId(noteId: Long) {
        dataStore.edit { it[NOTE_ID] = noteId }
    }

    suspend fun getNoteId() =
        dataStore.data.map { it[NOTE_ID] }.first() ?: 0
}
