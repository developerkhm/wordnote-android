package com.donghyeon.wordnote.data

import com.donghyeon.wordnote.data.service.room.Item
import com.donghyeon.wordnote.data.source.LocalDataSource
import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun addItem(word: String, description: String) =
        localDataSource.addItem(Item(word, description))

    override suspend fun getItemAll() =
        localDataSource.getItemAll().map {
            ItemData(it.id, it.word, it.description)
        }

    override suspend fun getItem(id: Long) =
        localDataSource.getItem(id).let {
            ItemData(it.id, it.word, it.description)
        }

    override suspend fun removeItem(itemData: ItemData) =
        localDataSource.removeItem(
            Item(itemData.no, itemData.word, itemData.description)
        )
}
