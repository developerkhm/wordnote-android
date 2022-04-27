package com.donghyeon.wordnote.data.source

import com.donghyeon.wordnote.data.service.room.Item

interface LocalDataSource {

    suspend fun addItem(item: Item)

    suspend fun getItemAll(): List<Item>

    suspend fun getItem(id: Long): Item

    suspend fun removeItem(item: Item)
}
