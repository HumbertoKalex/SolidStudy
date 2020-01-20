package com.example.cleanarch.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarch.R
import com.example.cleanarch.favorite.adapter.FavoriteAdapter
import kotlinx.android.synthetic.main.activity_favorites.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritesView : AppCompatActivity() {

    private val viewModel: FavoritesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Favorites"
        setContentView(R.layout.activity_favorites)
        setUpRecycler()
    }

    private fun setUpRecycler() {
        rvFavorites.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvFavorites.adapter = FavoriteAdapter(this, viewModel.getFavorites())
    }

    override fun onResume() {
        super.onResume()
        setUpRecycler()
    }
}