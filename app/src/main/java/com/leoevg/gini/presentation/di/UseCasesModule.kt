package com.leoevg.gini.presentation.di

import com.leoevg.gini.domain.useCase.LoadPixabayItemsUseCase
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository
import com.leoevg.gini.domain.repository.PixabayItemsLocalRepository
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
        pixabayItemsLocalRepository: PixabayItemsLocalRepository,
        pixabayItemsRemoteRepository: PixabayItemsRemoteRepository
    ): LoadPixabayItemsUseCase {
        return LoadPixabayItemsUseCase(
            pixabayItemsLocalRepository = pixabayItemsLocalRepository,
            pixabayItemsRemoteRepository = pixabayItemsRemoteRepository
        )
    }
}