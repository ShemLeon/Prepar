package com.leoevg.gini.data.mapper

import com.leoevg.gini.data.network.model.PixabayApiResponse
import com.leoevg.gini.domain.model.CardAssembly
import com.leoevg.gini.domain.model.Cards

object PixabayServerDataMapper {
    fun convert(response: PixabayApiResponse): Cards {
        val cards = response.hits.mapNotNull { hit ->
            if (hit.id != null
                && hit.likes != null
                && hit.comments != null
                && hit.image != null
            ) {
                CardAssembly(
                    id = hit.id,
                    likes = hit.likes,
                    comments = hit.comments,
                    image = hit.image
                )
            } else {
                null
            }
        }
        return Cards(cards)
    }
}

//map - метод который делает из списка одних моделек список других моделек