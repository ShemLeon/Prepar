package com.leoevg.gini.data.network

import com.leoevg.gini.data.network.model.PixabayApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ServerApi {
    @GET("/api/?key=13398314-67b0a9023aca061e2950dbb5a")
    fun getPixabayList(): Call<PixabayApiResponse>
}