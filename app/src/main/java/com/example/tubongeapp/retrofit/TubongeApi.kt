package com.example.tubongeapp.retrofit

import com.example.tubongeapp.data.Post
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface TubongeApi {
    @GET("/kingsmunene/tubongeserver/posts")
    suspend fun getPosts(): Response<List<Post>>

    @FormUrlEncoded
    @POST("/kingsmunene/tubongeserver/posts")
    suspend fun pushPost(
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("description") description: String
    ): Response<Post>
}