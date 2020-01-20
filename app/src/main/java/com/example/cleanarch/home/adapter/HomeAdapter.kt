package com.example.cleanarch.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarch.R
import com.example.cleanarch.item.ItemView
import com.example.data.database.entity.TitleEntity
import kotlinx.android.synthetic.main.titles_layout.view.*

class HomeAdapter(private val titlesList: List<TitleEntity>) :
    RecyclerView.Adapter<HomeAdapter.TitlesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitlesViewHolder {
        return TitlesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.titles_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return titlesList.size
    }

    override fun onBindViewHolder(holder: TitlesViewHolder, position: Int) {
        holder.bind(titlesList[position])
    }

    inner class TitlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(titles: TitleEntity) = with(itemView) {

            itemView.txtTitle.text = titles.title
            itemView.txtAno.text = titles.year
            itemView.txtType.text = titles.type
            Glide.with(context)
                .load(titles.poster)
                .into(itemView.imgTitle)
            itemView.setOnClickListener {
                var intent = Intent(context, ItemView::class.java)
                intent.putExtra("response", titles)
                context.startActivity(intent)
            }

        }
    }
}