package com.leoevg.gini.data.room

import com.leoevg.gini.domain.model.Cards

interface Peremapper {

    fun getPixabayList(): Cards
    fun putPixabayList(cards: Cards)

}