package com.mustafa.newsappkotlin.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mustafa.newsappkotlin.R
import com.mustafa.newsappkotlin.models.ArticlesModel

class FavoritesAdapter : RecyclerView.Adapter<FavoritesAdapter.FavNewsHolder>() {
    private var data: List<ArticlesModel> = ArrayList()

    fun setData(data: List<ArticlesModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    class FavNewsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView

        init {
            title = view.findViewById(R.id.title_favorites)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavNewsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorites_item, parent, false)
        return FavNewsHolder(view)
    }

    override fun onBindViewHolder(holder: FavNewsHolder, position: Int) {
        holder.title.text = data[position].title
    }

    override fun getItemCount(): Int {
        return data.size
    }


}