package com.leoevg.gini.presentation.ui.screens.main

import com.leoevg.gini.domain.model.Cards

data class MainScreenState(
    val isLoading: Boolean = false,
    val cards: Cards = Cards(emptyList()),
    val error: String = "",
    val loadImagesIsLocal: Boolean = true

)
