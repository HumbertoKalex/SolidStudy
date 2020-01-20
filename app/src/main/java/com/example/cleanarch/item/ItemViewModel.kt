package com.example.cleanarch.item

import androidx.lifecycle.ViewModel
import com.example.data.database.entity.TitleEntity
import com.example.domain.interactor.InteractorSearch

class ItemViewModel(private val interactor: InteractorSearch): ViewModel() {

    fun favoriteTitle(title: TitleEntity){
        interactor.insertFavoriteTitles(title)
    }

    fun unFavoriteTitle(title: String){
        interactor.removeFavoriteTitles(title)
    }

    fun checkTitle(title: String):Boolean{
        return interactor.checkFavorite(title)
    }
}