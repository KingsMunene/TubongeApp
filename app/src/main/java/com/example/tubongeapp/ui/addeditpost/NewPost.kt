package com.example.tubongeapp.ui.addeditpost

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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tubongeapp.ui.TopAppBarItem
import com.example.tubongeapp.ui.tubongeui.TubongeViewModel
import com.example.tubongeapp.utils.TubongeEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPost(
    viewModel: AddEditPostViewModel = hiltViewModel(),
    tubongeViewModel: TubongeViewModel = hiltViewModel(),
    popBackStack: () -> Unit
) {
    val scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = 1) {
        viewModel.uiEvents.collect{event ->
            when(event){
                TubongeEvents.PopBackStack -> popBackStack()
                is TubongeEvents.Snackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        topBar = { TopAppBarItem(
            title = "Post",
            scrollBehavior = scrollBehavior,
            onSettings = {}
        ) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {viewModel.onEvent(AddEditPostEvents.savePost(tubongeViewModel.currentId
                )) }
            ) {
            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Save")
        }},
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {padding->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = viewModel.title,
                onValueChange = {viewModel.onEvent(AddEditPostEvents.OnEditTitle(it))},
                placeholder = { Text(text = "Title")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            OutlinedTextField(
                value = viewModel.description,
                onValueChange = {viewModel.onEvent(AddEditPostEvents.OnEditDescription(it))},
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
//    NewPost()
}