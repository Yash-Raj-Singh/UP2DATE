package com.example.up2date

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject
import java.util.ArrayList

class MainActivity : AppCompatActivity(), newsItemClicked {

    private lateinit var mAdapter: Newsadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
        mAdapter = Newsadapter(this)
        recyclerView.adapter = mAdapter
    }

    private fun fetchData(){

        val url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=104dfe7bf6294d6687ba78c0cb327dd3"

        //Alternate API
        //val url = "https://saurav.tech/NewsAPI/everything/cnn.json"

        val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener {
                val newsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<NewsData>()
                for(i in 0 until newsJsonArray.length()){
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }

                mAdapter.updatedNews(newsArray)

            },
            Response.ErrorListener {

            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"] = "Mozilla/5.0"
                return headers
            }
        }

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

    override fun onItemClick(item:NewsData){
       val builder =  CustomTabsIntent.Builder()
       val customTabsIntent = builder.build()
       customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }
}