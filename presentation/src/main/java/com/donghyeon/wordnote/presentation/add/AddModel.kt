package com.donghyeon.wordnote.presentation.add

data class AddModel(

    var noteId: Long = 0,
    var itemId: Long = 0,
    var note: String = "",
    var word: String = "",
    var description: String = "",
)
