package com.leoevg.gini.domain.useCase

import com.leoevg.gini.data.repository.PixabayItemsLocalRepositoryImpl
import com.leoevg.gini.data.repository.PixabayItemsRemoteRepositoryImpl
import com.leoevg.gini.data.util.ImageDownloader
import com.leoevg.gini.domain.model.Cards
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class LoadPixabayItemsUseCase @Inject constructor(
    private val localRepository: PixabayItemsLocalRepositoryImpl,
    private val remoteRepository: PixabayItemsRemoteRepositoryImpl,
    private val imageDownloader: ImageDownloader
) {
    suspend operator fun invoke(): Cards? {
        return withContext(Dispatchers.IO) {
            val localCards = localRepository.getPixabayList()
            if (localCards.cards.isNotEmpty()) {
                localCards
            } else {
                val remoteCards = remoteRepository.getAll()
                if (remoteCards != null) {
                    val cardsWithLocalPaths = remoteCards.cards.mapNotNull { card ->
                        val localPath = imageDownloader.downloadImage(card.image, card.id)
                        localPath?.let { card.copy(image = it) }
                    }
                    if (cardsWithLocalPaths.isNotEmpty()) {
                        val newCards = Cards(cardsWithLocalPaths)
                        localRepository.putPixabayList(newCards)
                        newCards
                    } else {
                        null
                    }
                } else {
                    null
                }
            }
        }
    }
}
