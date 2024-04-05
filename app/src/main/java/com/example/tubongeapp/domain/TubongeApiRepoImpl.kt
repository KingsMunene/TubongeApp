package com.example.tubongeapp.domain

import com.example.tubongeapp.data.Post
import com.example.tubongeapp.retrofit.TubongeApi
import retrofit2.Response


class TubongeApiRepoImpl(
    private val tubongeApi: TubongeApi
): TubongeApiRepository {
    override suspend fun getPosts(): Response<List<Post>> {
        return tubongeApi.getPosts()
    }

    override suspend fun pushPost(id: Int, title: String, description: String): Response<Post> {
        return tubongeApi.pushPost(id, title, description)
    }
}