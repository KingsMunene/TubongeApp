package com.example.tubongeapp.domain

import com.example.tubongeapp.data.Post
import retrofit2.Response

interface TubongeApiRepository {
    suspend fun getPosts(): Response<List<Post>>
}