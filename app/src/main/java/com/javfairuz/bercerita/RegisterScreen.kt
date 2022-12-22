package com.javfairuz.bercerita

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen(
    navHostController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    fun validateRegister(){
        if(username.text != "" && email.text != "" && password.text != ""){
            navHostController.navigate("myapp")
        }else(
                Toast.makeText(context , "field tidak boleh kosong",Toast.LENGTH_SHORT).show()
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Register",
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
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Masukan Email anda") })
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Masukan Password anda") })
        Spacer(modifier = Modifier.padding(20.dp))

        Text(
            text = "Sudah Punya Akun? Masuk",
            Modifier.clickable {
                navHostController.navigate("login")
            })
        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {validateRegister() }) {
            Text(text = "Register")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewRegister() {
    RegisterScreen()
}