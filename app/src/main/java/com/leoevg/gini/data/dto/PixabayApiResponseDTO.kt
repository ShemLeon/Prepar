package com.leoevg.gini.data.dto

data class PixabayApiResponseDTO(
    val total: Int,
    val totalHits: Int,
    val hits: List<PixabayItemDTO>
)