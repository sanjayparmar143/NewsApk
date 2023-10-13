package com.example.newsapk.Interface

import com.example.newsapk.Model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/v2/everything")
    fun getNews(

        @Query("q") q:String,
        @Query("from") from:String,
        @Query("sortBy") sortBy:String,
        @Query("apiKey") apiKey:String,

        ) : Call<NewsModel>
}