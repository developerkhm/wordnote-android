package com.donghyeon.wordnote.data.service.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(item: Item)

    @Query("SELECT * FROM Item")
    fun getItemAll(): List<Item>

    @Query("SELECT * FROM Item WHERE id = :id")
    fun getItem(id: Long): Item

    @Delete
    fun removeItem(item: Item)
}
