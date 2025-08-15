package com.leoevg.gini.domain.repository

import com.leoevg.gini.domain.model.Cards

interface PixabayItemsRoomRepository {

    fun getPixabayList(): Cards
    fun putPixabayList(cards: Cards)

}