package com.example.up2date

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity(), newsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val s = fetchData()
        val adapter = Newsadapter(s, this)
        recyclerView.adapter = adapter
    }

    private fun fetchData(): ArrayList<String>{
        val lists = ArrayList<String>()
        for(i in 0 until 50){
            lists.add("Item is $i")
        }

        return lists
    }

    override fun onItemClick(item:String){
        Toast.makeText(this, "Item is $item", Toast.LENGTH_LONG).show()
    }
}