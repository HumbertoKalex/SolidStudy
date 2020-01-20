package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entity.TitleEntity

@Dao
interface TitlesDao {

    @Query("SELECT * FROM title WHERE title = :search")
    fun getFavorite(search: String): List<TitleEntity>

    @Query("SELECT * FROM title")
    fun getAllFavorite(): List<TitleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTitle(title: TitleEntity)

    @Query("DELETE FROM title WHERE title = :title")
    fun removeTitle(title: String)

}