package com.leoevg.gini.domain.repository

import com.leoevg.gini.domain.model.CardAssembly
import com.leoevg.gini.domain.model.Cards

interface PixabayItemsRemoteRepository {
    fun getAll(): Cards?
}