package com.donghyeon.wordnote.di

import com.donghyeon.wordnote.domain.dispatcher.Dispatcher
import com.donghyeon.wordnote.domain.dispatcher.DispatcherImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DispatcherModule {

    @Provides
    fun providesDispatcher(): Dispatcher = DispatcherImpl()
}
