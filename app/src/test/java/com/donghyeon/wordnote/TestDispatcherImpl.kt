package com.donghyeon.wordnote

import com.donghyeon.wordnote.domain.dispatcher.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher

@ExperimentalCoroutinesApi
class TestDispatcherImpl(
    private val testDispatcher: TestDispatcher
) : Dispatcher {

    override val main: CoroutineDispatcher get() = testDispatcher
    override val io: CoroutineDispatcher get() = testDispatcher
    override val default: CoroutineDispatcher get() = testDispatcher
}
