package com.example.data.repository

import android.util.Log
import com.example.data.network.SealedResource
import com.example.data.repository.models.ResponseSearch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositorySearch(private val searchApi: SearchApi) {

    private val apiKey = "279161f6"

    fun searchTitle(search: String, callback: (SealedResource<ResponseSearch>?) -> Unit) {

        searchApi.searchTitle(apiKey, search).enqueue(object : Callback<ResponseSearch> {
            override fun onFailure(call: Call<ResponseSearch>, t: Throwable) {
                Log.wtf("Error", t.message)
                callback(SealedResource.create(t))
            }

            override fun onResponse(
                call: Call<ResponseSearch>,
                response: Response<ResponseSearch>
            ) {
                callback(SealedResource.create(response))
            }
        })
    }


}