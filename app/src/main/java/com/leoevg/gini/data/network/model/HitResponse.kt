package com.leoevg.gini.data.network.model

import com.google.gson.annotations.SerializedName

data class HitResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("webformatURL")
    val image: String?,

    @SerializedName("likes")
    val likes: Int?,

    @SerializedName("comments")
    val comments: Int?
)


//    "likes": 54,
//"comments": 27,
//"id": 9753185,
//"webformatURL": "https://pixabay.com/get/gdf2cbcd66a7cfcd339955a2c736978a1c0937115ee9a2d7a2c2667c4b420c39b7033f035e77f14b54c70400c73cac1d4661b259cebc18d872f3886e7467a878a_640.jpg",

/*
  "total": 1981437,
    "totalHits": 500,
    "hits": [
 */