package com.donghyeon.wordnote.data.service.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val note: String
) {

    constructor(
        note: String
    ) : this(0, note)
}
