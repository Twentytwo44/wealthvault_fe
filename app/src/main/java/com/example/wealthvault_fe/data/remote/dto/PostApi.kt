package com.example.wealthvault_fe.data.remote.dto

import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    suspend fun getPosts(): List<PostDto>
}