package com.leoevg.gini.data.dto

data class PixabayItemDTO(
    val id: Int,
    val pageUrl: String,
    val type: String,
    val largeImageURL: String,
    val downloads: Int,
    val likes: Int,
    val comments: Int
)

// модель, которая будет перемещаться по сети через ремоут апи и наше приложение
