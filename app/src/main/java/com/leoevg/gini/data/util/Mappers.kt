package com.leoevg.gini.data.util

import com.leoevg.gini.data.dto.PixabayItemDTO
import com.leoevg.gini.data.entities.PixabayItemEntity
import com.leoevg.gini.domain.model.PixabayItem
import com.leoevg.gini.presentation.ui.components.PixabayItem

fun PixabayItem.toEntity() = PixabayItemEntity(
    id = this.id,
    likes = this.likes,
    comments = this.comments
)


fun PixabayItemEntity.toModel() = PixabayItem(
    id = this.id,
    likes = this.likes,
    comments = this.comments
)

fun PixabayItemDTO.toModel() = PixabayItem(
    id = this.id,
    likes = this.likes,
    comments = this.comments
)