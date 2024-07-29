package com.example.chatbot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class chatviewmodel : ViewModel() {
    val messageList by lazy { mutableStateListOf<Messagemodel>() }

        val GenerativeModel: GenerativeModel = GenerativeModel(
            modelName = "gemini-1.5-flash",
            apiKey = constants.apikey
        )
        fun sendMessage(question : String){
            viewModelScope. launch {
                try{
                    val chat = GenerativeModel.startChat(
                        history = messageList.map {
                            content(it.role){ text(it.message)}
                        }.toList()
                    )

                    messageList.add(Messagemodel(question, "user"))
                    messageList.add(Messagemodel("Typing...", "model"))
                    val response=chat.sendMessage(question)
                    messageList.removeLast()
                    messageList.add(Messagemodel(response.text.toString(), "model"))

//                Log.i("response from gemini", response.text.toString())
                }catch (e: Exception){
                    messageList.removeLast()
                    messageList.add(Messagemodel("Error: ${e.message}", "model"))
                }
                }

        }

    }
