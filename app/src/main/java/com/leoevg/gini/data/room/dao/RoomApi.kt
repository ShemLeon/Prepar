package com.leoevg.gini.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.leoevg.gini.data.room.entities.PixabayItemEntity

@Dao
interface RoomApi {

    @Insert
    fun addPixabayItem(pixabayItem: PixabayItemEntity)

    @Insert
    fun addPixabayItems(pixabayItemsList: List<PixabayItemEntity>)

    @Query("SELECT * FROM pixabay_items")
    fun getPixabayItems(): List<PixabayItemEntity>
}