package com.example.wealthvault_fe.domain.repository

import com.example.wealthvault_fe.common.Resource
import com.example.wealthvault_fe.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    // We return Flow to support reactive streams
    fun getPosts(): Flow<Resource<List<Post>>>

}