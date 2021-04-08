package com.example.up2date

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class Newsadapter( private val listerner: newsItemClicked): RecyclerView.Adapter<NewsviewHolder>() {
    private val items: ArrayList<NewsData> = ArrayList()
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
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.imgurl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updatedNews(updatedNewsData: ArrayList<NewsData>){
        items.clear()
        items.addAll(updatedNewsData)

        notifyDataSetChanged()
    }
}

class NewsviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.titleee)
    val image: ImageView = itemView.findViewById(R.id.image)
    val author: TextView = itemView.findViewById(R.id.author)

}

interface newsItemClicked{
    fun onItemClick(item: NewsData)
}