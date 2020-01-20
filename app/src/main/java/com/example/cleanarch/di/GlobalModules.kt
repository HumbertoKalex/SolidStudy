package com.example.cleanarch.di

import androidx.room.Room
import com.example.cleanarch.favorite.FavoritesViewModel
import com.example.cleanarch.home.HomeViewModel
import com.example.cleanarch.item.ItemViewModel
import com.example.data.database.DataBase
import com.example.data.network.RetrofitInstance
import com.example.data.repository.RepositorySearch
import com.example.domain.interactor.InteractorSearch
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val modules = module {

    single {
        Room.databaseBuilder(get(), DataBase::class.java, "title-db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    single { RepositorySearch(RetrofitInstance.createInstance()) }
    factory { InteractorSearch(get(), get()) }

    viewModel { HomeViewModel(get()) }
    viewModel { ItemViewModel(get()) }
    viewModel { FavoritesViewModel(get()) }
}
