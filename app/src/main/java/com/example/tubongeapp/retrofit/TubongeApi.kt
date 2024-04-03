package com.example.tubongeapp.retrofit

import com.example.tubongeapp.data.Post
import retrofit2.Response
import retrofit2.http.GET

interface TubongeApi {
    @GET("/kingsmunene/tubongeserver/posts")
    suspend fun getPosts(): Response<List<Post>>
}