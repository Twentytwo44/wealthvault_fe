package com.example.wealthvault_fe.presentation.feature.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wealthvault_fe.common.Resource
import com.example.wealthvault_fe.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PostsState())
    val state: StateFlow<PostsState> = _state

    init {
        getPosts()
    }

    private fun getPosts() {
        getPostsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PostsState(posts = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PostsState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = PostsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}