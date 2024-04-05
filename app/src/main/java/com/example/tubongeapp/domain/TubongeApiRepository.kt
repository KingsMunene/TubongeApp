package com.example.tubongeapp.domain

import com.example.tubongeapp.data.Post
import retrofit2.Response

interface TubongeApiRepository {
    suspend fun getPosts(): Response<List<Post>>
    suspend fun pushPost(
        id: Int,
        title: String,
        description: String
    ): Response<Post>
}