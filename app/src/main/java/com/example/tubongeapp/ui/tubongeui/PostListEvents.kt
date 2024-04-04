package com.example.tubongeapp.ui.tubongeui

import com.example.tubongeapp.data.Post

sealed class PostListEvents {
    data class PostClicked(val post: Post): PostListEvents()

    data class CommentButtonClicked(val postId: Int): PostListEvents()

    object NewPostClicked : PostListEvents()

    data class OnLikeClicked(val postId: Int): PostListEvents()
}