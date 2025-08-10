package com.leoevg.gini.data.dao

import android.media.Image
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.leoevg.gini.data.entities.PixabayItemEntity

@Dao
interface PixabayItemsDao {

    @Insert
    fun addPixabayItem(pixabayItem: PixabayItemEntity)

    @Insert
    fun addPixabayItems(pixabayItemsList: List<PixabayItemEntity>)

    @Query("SELECT * FROM pixabay_items")
    fun getPixabayItems(): List<PixabayItemEntity>
}