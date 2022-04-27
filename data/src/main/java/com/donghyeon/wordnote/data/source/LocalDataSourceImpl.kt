package com.donghyeon.wordnote.data.source

import com.donghyeon.wordnote.data.service.datastore.DataStoreService
import com.donghyeon.wordnote.data.service.room.Item
import com.donghyeon.wordnote.data.service.room.RoomService
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dataStoreService: DataStoreService,
    private val roomService: RoomService
) : LocalDataSource {

    override suspend fun addItem(item: Item) = roomService.itemDao().addItem(item)

    override suspend fun getItemAll() = roomService.itemDao().getItemAll()

    override suspend fun getItem(id: Long) = roomService.itemDao().getItem(id)

    override suspend fun removeItem(item: Item) = roomService.itemDao().removeItem(item)
}
