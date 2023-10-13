package com.example.newsapk.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapk.Model.ArticlesItem
import com.example.newsapk.databinding.NewsItemBinding

class NewsAdapter(List: ArrayList<ArticlesItem>) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    lateinit var context: Context
    var List = List

    class NewsHolder(itemView: NewsItemBinding) : RecyclerView.ViewHolder(itemView.root) {

        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {

        context = parent.context

        var binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(binding)

    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        Glide.with(context).load(List.get(position).urlToImage).into(holder.binding.imgnews)

        holder.binding.apply {

            List.get(position).apply {

                txttitle.text = title.toString()
                txtdescription.text = description.toString()




            }
        }
    }
}