package com.example.wealthvault_fe.data.remote.dto

import com.example.wealthvault_fe.domain.model.Post
import com.google.gson.annotations.SerializedName

data class PostDto(
    val id: Int,
    val userId: Int,
    val title: String,
    @SerializedName("body") val content: String // สมมติ JSON ส่งมาเป็น content แต่เราอยาก map
)

// Extension function แปลง DTO -> Domain Model
fun PostDto.toPost(): Post {
    return Post(
        id = id,
        title = title,
        body = content
    )
}