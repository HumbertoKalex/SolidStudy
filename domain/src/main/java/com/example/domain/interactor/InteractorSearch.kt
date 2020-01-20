package com.example.domain.interactor

import com.example.data.database.DataBase
import com.example.data.database.entity.TitleEntity
import com.example.data.network.ApiEmptyResponse
import com.example.data.network.ApiErrorResponse
import com.example.data.network.ApiSuccessResponse
import com.example.data.network.ResponseResource
import com.example.data.repository.RepositorySearch

class InteractorSearch(
    private val repository: RepositorySearch,
    private val dataBase: DataBase
) {

    fun getTitle(search: String, callback: (ResponseResource) -> Unit) {
        repository.searchTitle(search) {
            when (it) {
                is ApiSuccessResponse -> callback(ResponseResource(true, it.body))
                is ApiErrorResponse -> callback(ResponseResource(false, null))
                is ApiEmptyResponse -> callback(ResponseResource(false, null))
            }
        }
    }

    fun getFavoriteTitles(): List<TitleEntity> {
        return dataBase.titlesDao().getAllFavorite()
    }

    fun insertFavoriteTitles(title: TitleEntity) {
        dataBase.titlesDao().insertTitle(title)
    }

    fun removeFavoriteTitles(title: String) {
        dataBase.titlesDao().removeTitle(title)
    }

    fun checkFavorite(search: String): Boolean {
        return when (dataBase.titlesDao().getFavorite(search).size) {
            0 -> false
            else -> true
        }
    }

}