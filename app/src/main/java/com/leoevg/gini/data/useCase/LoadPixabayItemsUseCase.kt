package com.leoevg.gini.data.useCase

import com.leoevg.gini.data.dao.PixabayItemsDao
import com.leoevg.gini.data.entities.PixabayItemEntity
import com.leoevg.gini.data.util.toEntity
import com.leoevg.gini.data.util.toModel
import com.leoevg.gini.domain.model.PixabayItem
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository
import javax.inject.Inject


class LoadPixabayItemsUseCase @Inject constructor(
    private val pixabayItemsDao: PixabayItemsDao,
    private val  pixabayItemsRemoteRepository: PixabayItemsRemoteRepository
){
    operator fun invoke(updateData: (List<PixabayItem>) -> Unit){
        val items = pixabayItemsDao.getPixabayItems()
        updateData(items.map(PixabayItemEntity::toModel))

        val updateditems =  pixabayItemsRemoteRepository.getAll()
        updateData(updateditems)

        val updatedItems =  pixabayItemsRemoteRepository.getAll()
        pixabayItemsDao.addPixabayItems(updatedItems.map(PixabayItem::toEntity))
    }

}
