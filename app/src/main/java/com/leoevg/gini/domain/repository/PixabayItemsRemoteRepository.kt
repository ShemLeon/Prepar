package com.leoevg.gini.domain.repository

import com.leoevg.gini.domain.model.PixabayItem

interface PixabayItemsRemoteRepository {
    fun getAll(): List<PixabayItem>
}