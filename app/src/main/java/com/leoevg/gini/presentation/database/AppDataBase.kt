package com.leoevg.gini.presentation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leoevg.gini.data.dao.PixabayItemsDao
import com.leoevg.gini.data.entities.PixabayItemEntity

@Database(entities = [PixabayItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getPixabayItemsDao(): PixabayItemsDao
}