package com.donghyeon.wordnote.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.donghyeon.wordnote.data.RepositoryImpl
import com.donghyeon.wordnote.data.service.room.RoomService
import com.donghyeon.wordnote.data.source.LocalDataSource
import com.donghyeon.wordnote.data.source.LocalDataSourceImpl
import com.donghyeon.wordnote.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    private val Context.dataStore: DataStore<Preferences>
        by preferencesDataStore("DataStore")

    @Provides
    fun provideDataStoreService(
        application: Application
    ) = application.applicationContext.dataStore

    @Provides
    fun provideRoomService(
        application: Application
    ): RoomService = Room.databaseBuilder(
        application,
        RoomService::class.java,
        "Room"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun providesLocalDataSource(
        source: LocalDataSourceImpl
    ): LocalDataSource = source

    @Singleton
    @Provides
    fun providesRepository(
        repository: RepositoryImpl
    ): Repository = repository
}
