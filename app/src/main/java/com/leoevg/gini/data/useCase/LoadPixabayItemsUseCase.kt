package com.leoevg.gini.data.useCase

import com.leoevg.gini.data.room.dao.PixabayItemsRoomRepository
import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository
import javax.inject.Inject


class LoadPixabayItemsUseCase @Inject constructor(
    private val pixabayItemsRoomRepository: PixabayItemsRoomRepository,
    private val pixabayItemsRemoteRepository: PixabayItemsRemoteRepository
) {
    operator fun invoke(isLocal: Boolean): Cards? {
        return if (isLocal) {
//            pixabayItemsDao.getPixabayItems()
            TODO()
        } else {
            pixabayItemsRemoteRepository.getAll()
        }

    }
}
