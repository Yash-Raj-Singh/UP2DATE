package com.example.up2date

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Newsadapter(private val items: ArrayList<String>, private val listerner: newsItemClicked): RecyclerView.Adapter<NewsviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_newsviewholder, parent, false)
        val viewholder = NewsviewHolder(view)
        view.setOnClickListener{
            listerner.onItemClick(items[viewholder.adapterPosition])
        }
        return viewholder
    }

    override fun onBindViewHolder(holder: NewsviewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class NewsviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.titleee)
}

interface newsItemClicked{
    fun onItemClick(item: String)
}