package com.example.cleanarch.item

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.cleanarch.R
import com.example.data.database.entity.TitleEntity
import kotlinx.android.synthetic.main.item_layout.*
import org.koin.android.viewmodel.ext.android.viewModel

class ItemView : AppCompatActivity() {

    private val viewModel: ItemViewModel by viewModel()
    private lateinit var title: TitleEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_layout)

        intent.extras?.let {
            title = it.getSerializable("response") as TitleEntity
        }
        checkTitle()
        formatView()
    }

    private fun formatView() {
        txtTitleFav.text = title.title
        txtAnoFav.text = title.year
        txtTypeFav.text = title.type
        Glide.with(this)
            .load(title.poster)
            .into(imgTitleFav)
        btnFavorite.setOnClickListener {
            viewModel.favoriteTitle(title)
            checkTitle()
        }
        btnUnfavorite.setOnClickListener {
            viewModel.unFavoriteTitle(title.title)
            checkTitle()
        }
    }

    private fun checkTitle() {
        title.title.let {
            btnFavorite.isEnabled = !viewModel.checkTitle(it)
        }
    }
}