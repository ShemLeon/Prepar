package com.leoevg.gini.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceManager {
    private const val HOST = "https://pixabay.com"
    var apiService: ServerApi = createApiService()

    private fun createApiService(): ServerApi {
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ServerApi::class.java)
    }
}

/*

 */