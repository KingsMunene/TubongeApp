package com.example.tubongeapp.ui.addeditpost

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tubongeapp.domain.TubongeApiRepository

import com.example.tubongeapp.utils.TubongeEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AddEditPostViewModel @Inject constructor(
    private val repository: TubongeApiRepository,
): ViewModel() {

    var title: String by mutableStateOf("")
        private set
    var description: String by mutableStateOf("")
        private set

    private val _uiEvents = Channel<TubongeEvents>()
    val uiEvents = _uiEvents.receiveAsFlow()

    fun onEvent(event: AddEditPostEvents){
        when(event){
            is AddEditPostEvents.OnEditDescription -> {
                description = event.description
            }
            is AddEditPostEvents.OnEditTitle -> {
                title = event.title

            }

            is AddEditPostEvents.savePost -> {

                viewModelScope.launch {
                    try {

                        val response = repository.pushPost(
                            id = event.lastPostId++,
                            title = title,
                            description = description
                        )
                        if (response.isSuccessful){
                            sendEvent(TubongeEvents.Snackbar(
                                "{${response.body()}}",
                                null
                            ))
                            Log.e("NEWPOST", "Posted Successfully")
                            sendEvent(TubongeEvents.PopBackStack)
                        }
                    }catch (e: IOException){
                        Log.e("NEWPOST", "${e.message}")
                        sendEvent(TubongeEvents.Snackbar(
                            "Not Posted",
                            null
                        ))
                    }
                }
            }
        }
    }



    private fun sendEvent(event: TubongeEvents){
        viewModelScope.launch {
            _uiEvents.send(event)
        }
    }
}