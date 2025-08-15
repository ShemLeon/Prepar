package com.leoevg.gini.data.repository

import com.leoevg.gini.data.room.dao.RoomApi
import com.leoevg.gini.data.room.entities.PixabayItemEntity
import com.leoevg.gini.domain.model.CardUI
import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.repository.PixabayItemsRoomRepository
import javax.inject.Inject

class PixabayItemsRoomRepositoryImpl @Inject constructor(
    val roomApi: RoomApi
) : PixabayItemsRoomRepository {
    override fun getPixabayList(): Cards {
        val items = roomApi.getPixabayItems()
        val cards = items.map {
            CardUI(
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
        roomApi.addPixabayItems(entities)
    }

}