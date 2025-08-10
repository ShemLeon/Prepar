package com.leoevg.gini.presentation.ui.components

import com.google.gson.annotations.SerializedName

data class pixdataclas(

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("webformatURL")
    val image: String = "",

    @SerializedName("likes")
    val likes: Int = 0,

    @SerializedName("comments")
    val comments: Int = 0
)


//    "likes": 54,
//"comments": 27,
//"id": 9753185,
//"userImageURL": "https://cdn.pixabay.com/user/2023/03/31/01-22-48-937_250x250.jpg",