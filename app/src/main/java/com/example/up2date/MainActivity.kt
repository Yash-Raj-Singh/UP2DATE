package com.example.up2date

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val s = fetchData()
        val adapter = Newsadapter(s)
        recyclerView.adapter = adapter
    }

    private fun fetchData(): ArrayList<String>{
        val lists = ArrayList<String>()
        for(i in 0 until 50){
            lists.add("Item is $i")
        }

        return lists
    }
}