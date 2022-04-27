package com.donghyeon.wordnote.di

import com.donghyeon.wordnote.domain.repository.Repository
import com.donghyeon.wordnote.domain.usecase.ItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesItemUseCase(
        repository: Repository
    ) = ItemUseCase(repository)
}
