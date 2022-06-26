package com.donghyeon.wordnote.di

import com.donghyeon.wordnote.domain.dispatcher.Dispatcher
import com.donghyeon.wordnote.domain.dispatcher.DispatcherImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Singleton
    @Provides
    fun providesDispatcher(): Dispatcher = DispatcherImpl()
}
