package com.donghyeon.wordnote.data.mapper

import com.donghyeon.wordnote.data.service.room.Item
import com.donghyeon.wordnote.data.service.room.Note
import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.domain.model.NoteData

object Mapper {

    fun noteList(noteList: List<Note>) =
        noteList.map {
            NoteData(it.id, it.note)
        }

    fun itemList(itemList: List<Item>) =
        itemList.map {
            ItemData(it.id, it.noteId, it.word, it.description)
        }
}
