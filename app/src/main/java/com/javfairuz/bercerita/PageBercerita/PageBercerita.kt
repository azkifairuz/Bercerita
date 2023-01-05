package com.javfairuz.bercerita.PageBercerita

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text

import androidx.compose.material.TextField
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = bercerita,
            onValueChange = { bercerita = it },
            label = { Text(text = "Becerita") }
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .width(200.dp),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(text = "Kirim")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBercerita() {
    BerceritaScreen()
}