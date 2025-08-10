package com.leoevg.gini.presentation.ui.screens.main

import androidx.lifecycle.ViewModel
import com.leoevg.gini.data.useCase.LoadPixabayItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val loadPixabayItemsUseCase: LoadPixabayItemsUseCase
): ViewModel() {

}