package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetItemListUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() = flow {
        repository.getSelectedNoteId()?.let {
            emit(repository.getItemList(it))
            return@flow
        }
        emit(listOf())
    }.flowOn(Dispatchers.IO)
}
