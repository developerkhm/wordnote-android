package com.donghyeon.wordnote.data.service.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreServiceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreService {

    companion object DataStoreKey {
        val KEY = stringPreferencesKey("")
    }

    suspend fun set(string: String) {
        dataStore.edit { it[KEY] = string }
    }

    suspend fun get() = dataStore.data.map { it[KEY] }.first() ?: ""
}
