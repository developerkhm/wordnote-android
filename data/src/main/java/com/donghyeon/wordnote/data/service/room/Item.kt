package com.donghyeon.wordnote.data.service.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "description") val description: String
) {

    constructor(
        word: String,
        description: String
    ) : this(0, word, description)
}
