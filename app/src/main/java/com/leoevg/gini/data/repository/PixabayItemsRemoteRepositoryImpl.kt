package com.leoevg.gini.data.repository

import android.util.Log
import com.leoevg.gini.data.mapper.PixabayServerDataHandler
import com.leoevg.gini.data.network.ApiServiceManager
import com.leoevg.gini.domain.model.Cards
import com.leoevg.gini.domain.repository.PixabayItemsRemoteRepository

class PixabayItemsRemoteRepositoryImpl: PixabayItemsRemoteRepository {

    override fun getAll(): Cards? {
        // обращаемся тут к серверу и обрабатываем
        try {
            val service = ApiServiceManager.apiService
            val response = service.getPixabayList().execute()
            if (response.isSuccessful) {
                val pixabayApiResponse = response.body()
                return pixabayApiResponse?.let{
                    PixabayServerDataHandler.convert(it)
                }
            }
        } catch (e: Exception) {
            Log.e("PixabayItemsRemoteRepository", "Error: ${e.message}")
        }
        return null

    }


}