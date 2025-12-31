package com.example.wealthvault_fe.data.repository

import com.example.wealthvault_fe.common.Resource
import com.example.wealthvault_fe.data.remote.dto.PostApi
import com.example.wealthvault_fe.data.remote.dto.toPost
import com.example.wealthvault_fe.domain.model.Post
import com.example.wealthvault_fe.domain.repository.PostRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi
) : PostRepository {

    override fun getPosts(): Flow<Resource<List<Post>>> = flow {
        emit(Resource.Loading()) // 1. ส่งสถานะ Loading
        try {
            val remotePosts = api.getPosts() // ยิง API
            val posts = remotePosts.map { it.toPost() } // แปลง DTO -> Domain
            emit(Resource.Success(posts)) // 2. ส่งข้อมูลสำเร็จ
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}