package com.leoevg.gini.service

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.useCase.LoadPixabayItemsUseCase
import com.leoevg.gini.domain.useCase.SaveImagesToDatabaseUseCase
import kotlinx.coroutines.flow.update

class SyncImagesWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val loadPixabayItemsUseCase: LoadPixabayItemsUseCase,
    private val saveImagesToDatabaseUseCase: SaveImagesToDatabaseUseCase
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        try {
            val serverCards = loadAndSortImagesFromServer()
            serverCards?.let { cards ->
                saveImagesToRoom(serverCards)
            }
        } catch (e: Exception) {
            return Result.failure()
        }
        TODO("Not yet implemented")
    }


    private suspend fun loadAndSortImagesFromServer() =
        loadPixabayItemsUseCase.invoke(false)?.cards?.sortedByDescending { it.likes }

    private suspend fun saveImagesToRoom(cards: Cards) = saveImagesToDatabaseUseCase.invoke(cards)

}