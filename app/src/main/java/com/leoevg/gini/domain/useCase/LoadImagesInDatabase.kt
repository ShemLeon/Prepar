package com.leoevg.gini.domain.useCase

import com.leoevg.gini.data.room.dao.PixabayItemsRoomRepository
import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository
import javax.inject.Inject

class LoadImagesInDatabase @Inject constructor(
    private val pixabayItemsRoomRepository: PixabayItemsRoomRepository
) {
    operator fun invoke(cards: Cards): {
        return  pixabayItemsRoomRepository.addPixabayItems(cards.)
        }

    }
}
