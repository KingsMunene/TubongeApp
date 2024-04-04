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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tubongeapp.ui.TopAppBarItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostList(
    viewModel: TubongeViewModel = hiltViewModel()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {TopAppBarItem(
            title = "Tubonge App",
            scrollBehavior = scrollBehavior,
            onSettings = {}
        )},
        bottomBar = {},
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add Post")
        }}
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