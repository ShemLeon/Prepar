package com.leoevg.gini.service

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.useCase.LoadPixabayItemsUseCase
import com.leoevg.gini.domain.useCase.SaveImagesToDatabaseUseCase
import com.leoevg.gini.presentation.ui.util.PixabayLoader
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

class SyncImagesWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val loadPixabayItemsUseCase: LoadPixabayItemsUseCase,
    private val saveImagesToDatabaseUseCase: SaveImagesToDatabaseUseCase,

) : CoroutineWorker(context, workerParams) {
    private val pixabayImageLoader = PixabayLoader.create(context)

    override suspend fun doWork(): Result {
        try {
            val serverCards = loadAndSortImagesFromServer()
            serverCards?.let { cards ->
                saveImagesToRoom(Cards(serverCards))
                cachePixabayItemsToCoil(cards.map { it.imageUrl })
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

    private suspend fun cachePixabayItemsToCoil(urls: List<String>) = coroutineScope{
        val semaphore = Semaphore(5)
        urls.forEach { url ->
            async { semaphore.withPermit {
                val request = ImageRequest.Builder(applicationContext)
                    .data(url)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .networkCachePolicy(CachePolicy.ENABLED)
                    .build()
                pixabayImageLoader.execute(request = request)
            }

            }
        }
    }
}



