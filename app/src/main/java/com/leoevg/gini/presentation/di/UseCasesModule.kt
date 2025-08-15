package com.leoevg.gini.presentation.di

import com.leoevg.gini.data.room.dao.PixabayItemsRoomRepository
import com.leoevg.gini.data.useCase.LoadPixabayItemsUseCase
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Provides
    @Singleton
    fun provideLoadPixabayItemsUseCase(
        pixabayItemsRoomRepository: PixabayItemsRoomRepository,
        pixabayItemsRemoteRepository: PixabayItemsRemoteRepository
    ): LoadPixabayItemsUseCase {
        return LoadPixabayItemsUseCase(
            pixabayItemsRoomRepository = pixabayItemsRoomRepository,
            pixabayItemsRemoteRepository = pixabayItemsRemoteRepository
        )
    }

}