package com.mustafa.newsappkotlin.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mustafa.newsappkotlin.R
import com.mustafa.newsappkotlin.models.ArticlesModel
import com.mustafa.newsappkotlin.ui.BreakingNewsDirections

class HeadLinesAdapter : RecyclerView.Adapter<HeadLinesAdapter.NewsHolder>() {
    private var data: List<ArticlesModel> = ArrayList()

    fun setData(data: List<ArticlesModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun getArticle(position: Int): ArticlesModel {
        return data[position]
    }

    class NewsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val card: CardView

        init {
            title = view.findViewById(R.id.news_title)
            card = view.findViewById(R.id.headline_item_card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.headlines_item, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.title.text = data[position].title
        holder.card.setOnClickListener(View.OnClickListener { view ->
            val action = BreakingNewsDirections.actionBreakingNewsToNewsDetails(
                data[position].title,
                data[position].description,
                data[position].urlToImage,
                data[position].publishedAt
            )
            view.findNavController().navigate(action)
        })
    }

    override fun getItemCount(): Int {
        return data.size
    }

}