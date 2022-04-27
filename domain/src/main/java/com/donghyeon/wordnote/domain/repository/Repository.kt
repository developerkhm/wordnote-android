package com.donghyeon.wordnote.domain.repository

import com.donghyeon.wordnote.domain.model.ItemData

interface Repository {

    suspend fun addItem(word: String, description: String)

    suspend fun getItemAll(): List<ItemData>

    suspend fun getItem(id: Long): ItemData

    suspend fun removeItem(itemData: ItemData)
}
