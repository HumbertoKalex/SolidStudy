package com.example.data.repository

import com.example.data.repository.models.ResponseSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET(".")
    fun searchTitle(
        @Query("apikey") apiKey: String,
        @Query("s") search: String
    ):Call<ResponseSearch>
}