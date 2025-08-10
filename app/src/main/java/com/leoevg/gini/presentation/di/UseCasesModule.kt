package com.leoevg.gini.presentation.di

import com.leoevg.gini.data.dao.PixabayItemsDao
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
        pixabayItemsDao: PixabayItemsDao,
        pixabayItemsRemoteRepository: PixabayItemsRemoteRepository
    ): LoadPixabayItemsUseCase {
        return LoadPixabayItemsUseCase(
            pixabayItemsDao = pixabayItemsDao,
            pixabayItemsRemoteRepository = pixabayItemsRemoteRepository
        )
    }

}