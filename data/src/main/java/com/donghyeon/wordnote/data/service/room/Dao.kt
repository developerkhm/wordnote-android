package com.donghyeon.wordnote.data.service.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.donghyeon.wordnote.data.service.room.model.Item
import com.donghyeon.wordnote.data.service.room.model.Note

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note)

    @Query("SELECT * FROM Note")
    fun getNoteList(): List<Note>

    @Delete
    fun removeNote(note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(item: Item)

    @Query("SELECT * FROM Item WHERE noteId = :noteId")
    fun getItemList(noteId: Long): List<Item>

    @Delete
    fun removeItem(item: Item)

    @Query("DELETE FROM Item WHERE noteId = :noteId")
    fun removeItem(noteId: Long)
}
