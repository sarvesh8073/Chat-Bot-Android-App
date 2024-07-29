package com.example.chatbot

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.chatbot.ui.theme.modelmessage
import com.example.chatbot.ui.theme.usermessage

@Composable
fun chatpage(modifier: Modifier = Modifier, viewModel: chatviewmodel) {
    Column(modifier = modifier) {
        Headerapp()
        MessageList(
            modifier = Modifier.weight(1f),
            messageList = viewModel.messageList)
        messageinput(
            onMessageSend = {
                
                viewModel.sendMessage(it)
            }
        )
    }
}

@Composable
fun Headerapp() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.primary)) {
        Text(modifier = Modifier
            .padding(16.dp)
            .align(Alignment.Center),text="Ask Me Anything!",
            color = Color.White,
            fontSize = 22.sp)
        Text(modifier = Modifier
            .padding(16.dp)
            .align(Alignment.CenterEnd),text="By Sarvesh",
            color = Color.White,
            fontSize = 12.sp)
    }
}

@Composable
fun MessageList(modifier: Modifier = Modifier, messageList: List<Messagemodel>) {
    if(messageList.isEmpty()){
        Column (
            modifier=modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(160.dp),
                painter = painterResource(id = R.drawable.icons8_chatbot_94), contentDescription = "Icon",
                tint = Color.Unspecified)
            Text(text = "Ask me anything!!!", fontSize = 22.sp)
        }
    }else{
        LazyColumn(
            modifier = modifier,
            reverseLayout = true
        ){
            items(messageList.reversed()){
//            Text(text=it.message)
                messageRow(messagemodel = it)
            }
        }
    }

}


@Composable
fun messageRow(messagemodel: Messagemodel) {
    val isModel= messagemodel.role=="model"
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Box(
                modifier= Modifier
                    .align(
                        if (isModel) Alignment.BottomStart else Alignment.BottomEnd

                    )
                    .padding(
                        start = if (isModel) 8.dp else 70.dp,
                        end = if (isModel) 70.dp else 8.dp,
                        bottom = 8.dp,
                        top = 8.dp
                    )
                    .clip(RoundedCornerShape(48f))
                    .background(if (isModel) modelmessage else usermessage)
                    .padding(16.dp)


            ){
                SelectionContainer {
                    Text(text = messagemodel.message, fontWeight = FontWeight.W500, color = Color.White)
                }


            }

        }

    }
}





@Composable
fun messageinput(onMessageSend : (String) -> Unit) {
    var message by remember{
        mutableStateOf("")
    }
    Row(modifier = Modifier
            .padding(18.dp), verticalAlignment = Alignment.CenterVertically){
        OutlinedTextField(
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.weight(1f),
            value = message, onValueChange = {
            message=it
        })
        IconButton(onClick = {
            if(message.isNotEmpty()){
                onMessageSend(message)
                message=""
            }

        }) {
            Icon(imageVector = Icons.Default.Send, tint = MaterialTheme.colorScheme.primary, contentDescription = "Send" )
        }
    }
}