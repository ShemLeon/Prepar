package com.leoevg.gini.presentation.ui.screens.main

sealed interface MainScreenEvent {
    data object FetchImages : MainScreenEvent
}