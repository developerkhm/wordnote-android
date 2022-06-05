package com.donghyeon.wordnote.domain.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {

    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}
