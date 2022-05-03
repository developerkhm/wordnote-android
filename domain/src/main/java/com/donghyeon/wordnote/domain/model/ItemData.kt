package com.donghyeon.wordnote.domain.model

data class ItemData(
    val id: Long,
    val noteId: Long,
    val word: String,
    val description: String
)
