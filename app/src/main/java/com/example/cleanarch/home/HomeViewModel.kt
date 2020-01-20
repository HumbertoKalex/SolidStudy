package com.example.cleanarch.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.database.entity.TitleEntity
import com.example.domain.interactor.InteractorSearch

class HomeViewModel(private val interactor: InteractorSearch): ViewModel() {

    private var titles=MutableLiveData<List<TitleEntity>>()
    private var error=MutableLiveData<Unit>()

    fun search(search: String){
        interactor.getTitle(search){
            when(it.status){
                true->titles.postValue(it.response?.searches)
                false->error.postValue(null)
            }
        }
    }

    fun getSearch() : LiveData<List<TitleEntity>> = titles
    fun getError() : LiveData<Unit> = error
}