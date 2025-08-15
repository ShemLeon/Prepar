package com.leoevg.gini.domain.useCase

import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.repository.PixabayItemsRoomRepository
import javax.inject.Inject

class SaveImagesToDatabaseUseCase @Inject constructor(
    private val pixabayItemsRoomRepository: PixabayItemsRoomRepository
) {
    operator fun invoke(cards: Cards) {
       pixabayItemsRoomRepository.putPixabayList(cards)
    }
}



//// operator - это типа наш кастомный action (аналог + - / * или еще что-то)
//// invoke - синоним слова "выполнение" / "execute". он ничего не возвращает - поэтому ретурн не нужен. но не везде.
//
//fun main(){
//    val loadImagesInDatabase = LoadImagesInDatabase()
//    val chelovek = Human()
//    loadImagesInDatabase(cards = Cards(emptyList()))
//    chelovek()
//    chelovek + chelovek
//}
//
//class Human {
//    operator fun invoke() {}
//    operator fun plus(human: Human) {}
//}
