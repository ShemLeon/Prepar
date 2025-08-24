package com.leoevg.gini.data.network

import com.leoevg.gini.data.network.model.PixabayApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ServerApi {
    @GET("/api/?key=51680091-d95ce5e574237ff051c893755&per_page=200&order=popular&safesearch=true")
    fun getPixabayList(): Call<PixabayApiResponse>
}