package com.example.cleanarch.favorite

import androidx.lifecycle.ViewModel
import com.example.data.database.entity.TitleEntity
import com.example.domain.interactor.InteractorSearch

class FavoritesViewModel(private val interactorSearch: InteractorSearch) : ViewModel() {

    fun getFavorites(): List<TitleEntity> {
        return interactorSearch.getFavoriteTitles()
    }
}