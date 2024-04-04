package com.example.tubongeapp.ui.tubongeui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tubongeapp.ui.TopAppBarItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPost() {
    val scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = { TopAppBarItem(
            title = "Post",
            scrollBehavior = scrollBehavior,
            onSettings = {}
        ) },
        floatingActionButton = { FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Save")
        }}
    ) {padding->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Title")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(5.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun NewPostPrev() {
    NewPost()
}