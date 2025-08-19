package com.leoevg.gini.presentation.di

import com.leoevg.gini.data.repository.PixabayItemsRemoteRepositoryImpl
import com.leoevg.gini.data.repository.PixabayItemsLocalRepositoryImpl
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository
import com.leoevg.gini.domain.repository.PixabayItemsLocalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPixabayItemsRemoteRepository(
        pixabayItemsRemoteRepositoryImpl: PixabayItemsRemoteRepositoryImpl
    ): PixabayItemsRemoteRepository

    @Binds
    @Singleton
    abstract fun bindPixabayItemsRoomRepository(
        pixabayItemsLocalRepositoryImpl: PixabayItemsLocalRepositoryImpl
    ): PixabayItemsLocalRepository
}
