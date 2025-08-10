package com.leoevg.gini.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pixabay_items")
data class PixabayItemEntity(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "likes")
    val likes: Int,

    @ColumnInfo(name = "comments")
    val comments: Int


)
