package com.donghyeon.wordnote.data.service.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val noteId: Long,
    val word: String,
    val description: String
) {

    constructor(
        noteId: Long,
        word: String,
        description: String
    ) : this(0, noteId, word, description)
}
