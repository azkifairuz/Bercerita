package com.javfairuz.bercerita

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun LoginScreen(
    navHostController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    fun validateLogin(){
        if(username.text == "azki"){
            navHostController.navigate("myapp"){
                popUpTo("login"){inclusive = true}
            }
        }else{
            Toast.makeText(context,"Username salah",Toast.LENGTH_SHORT).show()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Masuk",
            style = MaterialTheme.typography.h1,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Masukan Username anda") })

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Masukan Password anda") })

        Spacer(modifier = Modifier.padding(20.dp))

        Text(text = "Belum Punya Akun?Daftar", Modifier.clickable {navHostController.navigate("register") })

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = { validateLogin() }) {
            Text(text = "Masuk")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewLogin() {
    LoginScreen()
}