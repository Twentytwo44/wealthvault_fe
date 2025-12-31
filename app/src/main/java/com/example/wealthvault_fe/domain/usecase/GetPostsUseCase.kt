package com.example.wealthvault_fe.domain.usecase

import com.example.wealthvault_fe.common.Resource
import com.example.wealthvault_fe.domain.model.Post
import com.example.wealthvault_fe.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(): Flow<Resource<List<Post>>> {

        return repository.getPosts()
    }
}