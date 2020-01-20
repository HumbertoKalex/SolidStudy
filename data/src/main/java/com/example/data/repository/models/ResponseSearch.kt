package com.example.data.repository.models

import com.example.data.database.entity.TitleEntity
import com.google.gson.annotations.SerializedName


data class ResponseSearch(
    @SerializedName("Search")
    val searches: List<TitleEntity>? = null,
    @SerializedName("totalResults")
    val totalResults: String? = null,
    @SerializedName("Response")
    val response: String? = null

)