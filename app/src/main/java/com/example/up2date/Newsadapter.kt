package com.example.up2date

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Newsadapter(private val items: ArrayList<String>): RecyclerView.Adapter<NewsviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_newsviewholder, parent, false)
        return NewsviewHolder(view)
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