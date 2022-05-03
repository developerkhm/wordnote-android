package com.donghyeon.wordnote.data.service.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ Note::class, Item::class ],
    version = 1
)
abstract class RoomService : RoomDatabase() {

    abstract fun dao(): Dao
}
