package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ItemUseCase(
    private val repository: Repository
) {

    fun add(word: String, description: String): Flow<Boolean> {
        return flow {
            repository.addItem(word, description)
            emit(true)
        }.flowOn(IO)
    }

    fun getItemAll(): Flow<List<ItemData>> {
        return flow {
            emit(repository.getItemAll())
        }.flowOn(IO)
    }

    fun getItem(id: Long): Flow<ItemData> {
        return flow {
            emit(repository.getItem(id))
        }.flowOn(IO)
    }

    fun removeItem(itemData: ItemData): Flow<List<ItemData>> {
        return flow {
            repository.removeItem(itemData)
            emit(repository.getItemAll())
        }.flowOn(IO)
    }
}
