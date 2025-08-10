package com.leoevg.gini.data.useCase

import com.leoevg.gini.data.dao.PixabayItemsDao
import com.leoevg.gini.data.entities.PixabayItemEntity
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository
import javax.inject.Inject


class LoadPixabayItemsUseCase @Inject constructor(
    private val pixabayItemsDao: PixabayItemsDao,
    private val remoteRepository: PixabayItemsRemoteRepository
){
    operator fun invoke(updateData: (List<PixabayItemEntity>) -> Unit){
        val items = pixabayItemsDao.getPixabayItems()
        updateData(items)
        val updatedItems = remoteRepository.getAll()
        pixabayItemsDao.addPixabayItems(updatedItems)
    }

}