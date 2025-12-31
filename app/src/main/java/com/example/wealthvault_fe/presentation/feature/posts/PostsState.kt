package com.example.wealthvault_fe.presentation.feature.posts

import com.example.wealthvault_fe.domain.model.Post

data class PostsState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String = ""
)