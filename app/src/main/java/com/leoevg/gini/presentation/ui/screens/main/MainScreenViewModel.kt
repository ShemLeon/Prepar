package com.leoevg.gini.presentation.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.useCase.LoadPixabayItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val loadPixabayItemsUseCase: LoadPixabayItemsUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<MainScreenState> = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState> = _state.asStateFlow()


    fun sendEvent(event: MainScreenEvent) {
        when (event) {
            is FetchImages -> {
                _state.value = _state.value.copy(isLoading = true)
                viewModelScope.launch {
                    loadImagesFromDatabaseRoom() ?: loadAndSortImagesFromServer() ?: handleError()
                }
            }
        }
    }

    private fun handleError() {
        _state.update {
            it.copy(
                isLoading = false,
                error = "We have not ETHERNET connection for download"
            )
        }
    }

    private fun loadImagesFromDatabaseRoom(): Unit? {
        val localCards = loadPixabayItemsUseCase.invoke(true)
        return localCards?.let {
            _state.update {
                it.copy(
                    isLoading = false,
                    cards = localCards
                )
            }
        }
    }

    private fun loadAndSortImagesFromServer(): Unit? {
        val serverCards = loadPixabayItemsUseCase.invoke(false)?.cards?.sortedByDescending { it.likes }
        return serverCards?.let {
            _state.update {
                it.copy(
                    isLoading = false,
                    cards = Cards(serverCards)
                )
            }
        }
    }



}