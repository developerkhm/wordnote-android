package com.donghyeon.wordnote.data.service.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.donghyeon.wordnote.data.service.room.model.Item
import com.donghyeon.wordnote.data.service.room.model.Note

@Database(
    entities = [ Note::class, Item::class ],
    exportSchema = false,
    version = 1
)
abstract class RoomService : RoomDatabase() {

    abstract fun dao(): Dao
}
