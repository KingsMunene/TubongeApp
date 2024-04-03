package com.example.tubongeapp.ui.tubongeui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tubongeapp.data.Post
import com.example.tubongeapp.domain.TubongeApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

const val TAG = "TUBONGEVIEWMODEL"

@HiltViewModel
class TubongeViewModel @Inject constructor(
    private val repository: TubongeApiRepository
) : ViewModel() {
    var posts: List<Post> by mutableStateOf(emptyList())

    init {
        viewModelScope.launch {
            try {
                val result = repository.getPosts()
                if (result.isSuccessful && result.body() != null) posts = result.body()!!
            }catch (e: IOException){
                Log.e(TAG, "${e.message}")
                posts = listOf(Post("This is an error", 1, "Error"))
            }catch (e:HttpException){
                Log.e(TAG, "${e.message}")
                posts = listOf(Post("This is an error", 1, "Error"))
            }
        }
    }
}