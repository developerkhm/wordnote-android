package com.donghyeon.wordnote.di

import com.donghyeon.wordnote.domain.repository.Repository
import com.donghyeon.wordnote.domain.usecase.AddItemUseCase
import com.donghyeon.wordnote.domain.usecase.AddNoteUseCase
import com.donghyeon.wordnote.domain.usecase.GetItemListUseCase
import com.donghyeon.wordnote.domain.usecase.GetNoteUseCase
import com.donghyeon.wordnote.domain.usecase.RemoveItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesAddNoteUseCase(
        repository: Repository
    ) = AddNoteUseCase(repository)

    @Provides
    fun providesGetNoteUseCase(
        repository: Repository
    ) = GetNoteUseCase(repository)

    @Provides
    fun providesAddItemUseCase(
        repository: Repository
    ) = AddItemUseCase(repository)

    @Provides
    fun providesGetItemListUseCase(
        repository: Repository
    ) = GetItemListUseCase(repository)

    @Provides
    fun providesRemoveItemUseCase(
        repository: Repository
    ) = RemoveItemUseCase(repository)
}
