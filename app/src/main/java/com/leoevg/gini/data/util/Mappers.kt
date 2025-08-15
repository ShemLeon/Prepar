package com.leoevg.gini.data.util

import com.leoevg.gini.data.dto.PixabayItemDTO
import com.leoevg.gini.data.room.entities.PixabayItemEntity
import com.leoevg.gini.domain.model.CardAssembly

fun CardAssembly.toEntity() = PixabayItemEntity(
    id = this.id,
    likes = this.likes,
    comments = this.comments
)


fun PixabayItemEntity.toModel() = CardAssembly(
    id = this.id,
    likes = this.likes,
    comments = this.comments
)

fun PixabayItemDTO.toModel() = CardAssembly(
    id = this.id,
    likes = this.likes,
    comments = this.comments
)