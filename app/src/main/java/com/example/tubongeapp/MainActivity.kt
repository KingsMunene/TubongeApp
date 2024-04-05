package com.example.tubongeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tubongeapp.ui.theme.TubongeAppTheme
import com.example.tubongeapp.ui.addeditpost.NewPost
import com.example.tubongeapp.ui.tubongeui.PostList
import com.example.tubongeapp.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TubongeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Routes.POSTLIST.name
                    ) {
                        composable(route = Routes.POSTLIST.name) {
                            PostList(navigate = { navController.navigate(it.route) })
                        }

                        composable(route = Routes.ADDEDITPOST.name) {
                            NewPost(
                                popBackStack = {navController.popBackStack()}
                            )
                        }

                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TubongeAppTheme {

    }
}