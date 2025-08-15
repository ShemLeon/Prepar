package com.leoevg.gini.presentation.di

import android.content.Context
import androidx.room.Room
import com.leoevg.gini.data.room.dao.RoomApi
import com.leoevg.gini.presentation.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "appDatabase.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): RoomApi {
        return appDatabase.getPixabayItemsDao()
    }
}