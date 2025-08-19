package com.leoevg.gini.domain.repository

import com.leoevg.gini.domain.model.Cards

interface PixabayItemsLocalRepository {
    fun getPixabayList(): Cards
    fun putPixabayList(cards: Cards)
}