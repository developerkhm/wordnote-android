package com.donghyeon.wordnote.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.donghyeon.wordnote.data.RepositoryImpl
import com.donghyeon.wordnote.data.service.datastore.DataStoreService
import com.donghyeon.wordnote.data.service.datastore.DataStoreServiceImpl
import com.donghyeon.wordnote.data.service.room.RoomService
import com.donghyeon.wordnote.data.source.LocalDataSource
import com.donghyeon.wordnote.data.source.LocalDataSourceImpl
import com.donghyeon.wordnote.domain.Repository
import com.donghyeon.wordnote.domain.dispatcher.Dispatcher
import com.donghyeon.wordnote.domain.dispatcher.DispatcherImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    private val Context.dataStore: DataStore<Preferences>
        by preferencesDataStore("WordNote")

    @Singleton
    @Provides
    fun providesDispatcher(): Dispatcher = DispatcherImpl()

    @Singleton
    @Provides
    fun provideDataStore(
        application: Application
    ) = application.applicationContext.dataStore

    @Singleton
    @Provides
    fun provideDataStoreService(
        service: DataStoreServiceImpl
    ): DataStoreService = service

    @Singleton
    @Provides
    fun provideRoom(
        application: Application
    ): RoomService {
        return Room.databaseBuilder(
            application,
            RoomService::class.java,
            "WordNote"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
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
