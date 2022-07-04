package com.donghyeon.wordnote.domain.usecase

import com.donghyeon.wordnote.domain.Repository
import com.donghyeon.wordnote.domain.dispatcher.Dispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppLoadCase @Inject constructor(
    private val dispatcher: Dispatcher,
    private val repository: Repository
) {

    suspend operator fun invoke() =
        withContext(dispatcher.io) {
            repository.init()
        }
}
