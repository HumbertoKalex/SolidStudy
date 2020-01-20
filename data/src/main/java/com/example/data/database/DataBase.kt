package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.database.converters.TitleConverter
import com.example.data.database.dao.TitlesDao
import com.example.data.database.entity.TitleEntity

@Database(entities = [TitleEntity::class], version = 1, exportSchema = false)
@TypeConverters(TitleConverter::class)
abstract class DataBase : RoomDatabase() {
    abstract fun titlesDao(): TitlesDao
}
