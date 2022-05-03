package com.donghyeon.wordnote.data.service.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreServiceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreService {

    companion object DataStoreKey {
        val SELECTED_NOTE_ID = longPreferencesKey("SELECTED_NOTE_ID")
    }

    override suspend fun setSelectedNoteId(noteId: Long): Long {
        dataStore.edit { it[SELECTED_NOTE_ID] = noteId }
        return noteId
    }

    override suspend fun getSelectedNoteId() =
        dataStore.data.map { it[SELECTED_NOTE_ID] }.first()
}
