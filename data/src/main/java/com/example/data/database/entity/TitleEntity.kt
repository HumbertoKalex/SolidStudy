package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "title")
data class TitleEntity(
    @PrimaryKey
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String? = null,
    @SerializedName("imdbID")
    val imdbID: String? = null,
    @SerializedName("Type")
    val type: String? = null,
    @SerializedName("Poster")
    val poster: String? = null
):Serializable
