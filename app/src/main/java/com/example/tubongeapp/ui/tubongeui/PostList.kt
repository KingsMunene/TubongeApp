package com.example.tubongeapp.ui.tubongeui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tubongeapp.ui.TopAppBarItem
import com.example.tubongeapp.utils.TubongeEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostList(
    viewModel: TubongeViewModel = hiltViewModel(),
    navigate: (TubongeEvents.Navigate) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState()}

    LaunchedEffect(key1 = 1) {
        viewModel.uiEvents.collect{event ->
            when(event){
                is TubongeEvents.Navigate -> navigate(event)
                is TubongeEvents.Snackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        topBar = {TopAppBarItem(
            title = "Tubonge App",
            scrollBehavior = scrollBehavior,
            onSettings = {}
        )},
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.onEvent(PostListEvents.NewPostClicked) }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add Post")
        }},
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {padding ->

        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {

            items(viewModel.posts){
                Spacer(modifier = Modifier.height(8.dp))
                PostListItem(it, onComment = {}, onLike = {})
            }
        }

    }
}