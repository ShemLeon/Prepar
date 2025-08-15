package com.leoevg.gini.presentation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leoevg.gini.data.room.dao.RoomApi
import com.leoevg.gini.data.room.entities.PixabayItemEntity

@Database(entities = [PixabayItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getPixabayItemsDao(): RoomApi
}