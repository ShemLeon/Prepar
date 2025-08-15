package com.leoevg.gini.domain.useCase

import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository
import com.leoevg.gini.domain.repository.PixabayItemsRoomRepository
import javax.inject.Inject


class LoadPixabayItemsUseCase @Inject constructor(
    private val pixabayItemsRoomRepository: PixabayItemsRoomRepository,
    private val pixabayItemsRemoteRepository: PixabayItemsRemoteRepository
) {
    operator fun invoke(isLocal: Boolean): Cards? {
        return if (isLocal) {
            pixabayItemsRoomRepository.getPixabayList()
        } else {
            pixabayItemsRemoteRepository.getAll()
        }

    }
}
