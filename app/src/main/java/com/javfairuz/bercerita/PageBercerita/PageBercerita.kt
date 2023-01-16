package com.javfairuz.bercerita.PageBercerita

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun BerceritaScreen() {
    var bercerita by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var response by remember {
        mutableStateOf("")

    }
    fun bercerita(){
        bercerita = TextFieldValue("")
        response = "Terimakasih Sudah Berani Cerita,maaf ai kami belum bisa meresponse"
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = " yuk, ceritain masalahmu disini",
        style = MaterialTheme.typography.h1)
        OutlinedTextField(
            value = bercerita,
            onValueChange = { bercerita = it },
            label = { Text(text = "Becerita") },
            modifier = Modifier.height(200.dp),
            
        )
        Button(
            onClick = { bercerita() },
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .width(200.dp),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(text = "Kirim", style = MaterialTheme.typography.button)
        }
        
        Text(text = response, style = MaterialTheme.typography.body1)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBercerita() {
    BerceritaScreen()
}