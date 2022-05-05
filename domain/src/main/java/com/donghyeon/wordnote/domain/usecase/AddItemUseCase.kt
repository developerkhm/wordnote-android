package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.regex.Pattern

class AddItemUseCase(
    private val repository: Repository
) {

    operator fun invoke(
        noteId: Long,
        word: String,
        description: String
    ) = flow {
        if (word.isEmpty()) {
            emit("단어를 입력하세요")
            return@flow
        }
        if (description.isEmpty()) {
            emit("설명을 입력하세요")
            return@flow
        }
        if (!Pattern.matches("^[a-zA-Z]*\$", word)) {
            emit("단어는 영문만 입력하세요")
            return@flow
        }
        repository.addItem(noteId, word, description)
        emit("추가 되었습니다")
        emit(true)
    }.flowOn(IO)
}
