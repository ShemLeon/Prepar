package com.leoevg.gini.data.room

import com.leoevg.gini.data.room.dao.PixabayItemsRoomRepository
import com.leoevg.gini.data.room.entities.PixabayItemEntity
import com.leoevg.gini.domain.model.CardAssembly
import com.leoevg.gini.domain.model.Cards

class PeremapperImpl(
    val pixabayItemsRoomRepository: PixabayItemsRoomRepository
) : Peremapper {
    override fun getPixabayList(): Cards {
        val items = pixabayItemsRoomRepository.getPixabayItems()
        val cards = items.map {
            CardAssembly(
                id = it.id,
                image = it.image,
                likes = it.likes,
                comments = it.comments
            )
        }
        return Cards(cards)
    }

    override fun putPixabayList(cards: Cards) {
        val entities = cards.cards.map {
            PixabayItemEntity(
                id = it.id,
                image = it.image,
                likes = it.likes,
                comments = it.comments
            )
        }
        pixabayItemsRoomRepository.addPixabayItems(entities)
    }

}