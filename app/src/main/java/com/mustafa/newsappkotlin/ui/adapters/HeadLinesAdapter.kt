package com.mustafa.newsappkotlin.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mustafa.newsappkotlin.R
import com.mustafa.newsappkotlin.models.ArticlesModel

class HeadLinesAdapter : RecyclerView.Adapter<HeadLinesAdapter.NewsHolder>() {
    private var data: List<ArticlesModel> =ArrayList()

    fun setData(data: List<ArticlesModel>) {
        this.data = data
        notifyDataSetChanged()
    }


    class NewsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView

        init {
            title = view.findViewById(R.id.news_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.headlines_item, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.title.text = data[position].title
    }

    override fun getItemCount(): Int {
        return data.size
    }

}