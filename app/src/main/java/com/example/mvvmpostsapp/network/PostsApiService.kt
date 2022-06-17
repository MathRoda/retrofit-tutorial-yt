package com.example.mvvmpostsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com"

private val retrofitPosts = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface PostsApiService {
    @GET("/comments")
    suspend fun getPosts(): List<Posts>
}

object InstanceApiService {
    val postsApiService: PostsApiService by lazy {
        retrofitPosts.create(PostsApiService::class.java)
    }
}