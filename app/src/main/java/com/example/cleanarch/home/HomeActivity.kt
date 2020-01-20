package com.example.cleanarch.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarch.R
import com.example.cleanarch.di.modules
import com.example.cleanarch.favorite.FavoritesView
import com.example.cleanarch.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        startKoin(this, listOf(modules))
        setUpObserver()
    }

    private fun setUpObserver() {
        btnSearch.setOnClickListener {
            showProgress()
            edtSearch.text.isNotEmpty().let {
                viewModel.search(edtSearch.text.toString())
            }
        }

        floatFavorites.setOnClickListener {
            startActivity(Intent(this, FavoritesView::class.java))
        }

        viewModel.getSearch().observe(this, Observer {
            hideProgress()
            rvHome.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rvHome.adapter = HomeAdapter(it)
        })

        viewModel.getError().observe(this, Observer {
            showError()
        })
    }

    private fun showProgress() {
        pgHome.visibility = View.VISIBLE
        rvHome.visibility = View.GONE
    }

    private fun hideProgress() {
        pgHome.visibility = View.GONE
        rvHome.visibility = View.VISIBLE
    }

    private fun showError() {
        hideProgress()
        Toast.makeText(this, "Pesquisa não encontrada", Toast.LENGTH_SHORT).show()
    }
}
