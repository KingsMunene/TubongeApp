package com.example.tubongeapp.ui.addeditpost

sealed class AddEditPostEvents {
    data class OnEditTitle(val title: String): AddEditPostEvents()
    data class OnEditDescription(val description: String): AddEditPostEvents()

    data class savePost(var lastPostId: Int): AddEditPostEvents()
}