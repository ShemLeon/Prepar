package com.leoevg.gini.presentation.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.useCase.LoadPixabayItemsUseCase
import com.leoevg.gini.domain.useCase.SaveImagesToDatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val loadPixabayItemsUseCase: LoadPixabayItemsUseCase,
    private val saveImagesToDatabaseUseCase: SaveImagesToDatabaseUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<MainScreenState> = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState> = _state.asStateFlow()

    fun sendEvent(event: MainScreenEvent) {
        when (event) {
            is FetchImages -> {
                _state.value = _state.value.copy(isLoading = true)
                viewModelScope.launch(Dispatchers.IO) {
                    loadImagesFromDatabaseRoom() ?: loadAndSortImagesFromServer().also { saveImagesToRoom() } ?: handleError()
                }
            }
        }
    }

    private fun saveImagesToRoom() {
        saveImagesToDatabaseUseCase.invoke(_state.value.cards)
    }

    private fun handleError() {
        _state.update {
            it.copy(
                isLoading = false,
                error = "We have not ETHERNET connection for download"
            )
        }
    }

    private suspend fun loadImagesFromDatabaseRoom(): Unit? {
        val localCards = loadPixabayItemsUseCase.invoke(true)
        if (localCards?.cards?.isEmpty() == true) return null

        return localCards?.let {
            _state.update {
                it.copy(
                    isLoading = false,
                    cards = localCards
                )
            }
        }
    }

    private suspend fun loadAndSortImagesFromServer(): Unit? {
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