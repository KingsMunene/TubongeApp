package com.example.tubongeapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomAppBar() {
    BottomAppBar(
        actions = {},
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add new Post")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun BottomBarPrev() {
    BottomAppBar()
}