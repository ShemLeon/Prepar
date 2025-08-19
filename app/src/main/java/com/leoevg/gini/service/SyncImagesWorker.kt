package com.leoevg.gini.service

import android.content.Context
import androidx.work.CoroutineWorker
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
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        try {
            val serverCards = loadAndSortImagesFromServer()
            serverCards?.let { cards ->
                saveImagesToRoom(Cards(serverCards))
                return Result.success()
            }
            return Result.failure()
        } catch (e: Exception) {
            return Result.failure()
        }
    }


    private suspend fun loadAndSortImagesFromServer() =
        loadPixabayItemsUseCase.invoke(false)?.cards?.sortedByDescending { it.likes }

    private fun saveImagesToRoom(cards: Cards) = saveImagesToDatabaseUseCase.invoke(cards)

}