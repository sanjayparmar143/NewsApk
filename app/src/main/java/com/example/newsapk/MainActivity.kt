package com.example.newsapk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsapk.Adapter.NewsAdapter
import com.example.newsapk.Api.ApiClient
import com.example.newsapk.Interface.ApiInterface
import com.example.newsapk.Model.ArticlesItem
import com.example.newsapk.Model.NewsModel
import com.example.newsapk.databinding.ActivityMainBinding
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    var List = ArrayList<ArticlesItem>()
    lateinit var adapter: NewsAdapter
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var Apiinterface = ApiClient.getApiClient().create(ApiInterface::class.java)

        Apiinterface.getNews(
            "tesla",
            "2023-08-21",
            "publishedt",
            "26ffdb5c703246d2ab717ceee3bd0cc4"
        ).enqueue(object : Callback<NewsModel> {
            override fun onResponse(
                call: retrofit2.Call<NewsModel>,
                response: retrofit2.Response<NewsModel>
            ) {
                if (response.isSuccessful) {


                    List = response.body()?.articles as ArrayList<ArticlesItem>
                    adapter = NewsAdapter(List)
                    binding.rcvnews.layoutManager = GridLayoutManager(this@MainActivity, 1)
                    binding.rcvnews.adapter = adapter
                    Log.e(TAG, "onResponse: " + response.body().toString())
                } else{
                    Log.e(TAG, "onResponse: 4567 " + response.toString())

                }
            }

            override fun onFailure(call: retrofit2.Call<NewsModel>, t: Throwable) {
                Log.e(TAG, "onFailure: " + t.message)
            }

        })


    }

}
