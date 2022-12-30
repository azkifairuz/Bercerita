package com.javfairuz.bercerita

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
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

    fun validateRegister() {
        if (username.text != "" && email.text != "" && password.text != "") {
            navHostController.navigate("myapp")
        } else (
                Toast.makeText(context, "field tidak boleh kosong", Toast.LENGTH_SHORT).show()
                )
    }
    Scaffold(modifier = Modifier.padding(20.dp),
        topBar = {
            IconButton(onClick = { navHostController.navigate("login") }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {


            Text(
                text = "Daftar",
                style = MaterialTheme.typography.h1,
                fontSize = 32.sp,
                fontWeight = FontWeight.W700,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Row( modifier = Modifier) {
                Text(
                    text = "Sudah Punya Akun?",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "Login",
                    modifier = Modifier.clickable { navHostController.navigate("login") },
                    color = Color.Blue,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Email",
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextField(
                value = username,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { username = it },
                placeholder = { Text(text = "Masukan Ussername  anda") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.padding(16.dp))

            Text(
                text = "Username",
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.padding(8.dp))

            TextField(
                value = email,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { email = it },
                placeholder = { Text(text = "Masukan Email  anda") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.padding(16.dp))

            Text(
                text = "Password",
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextField(
                value = password,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { password = it },
                placeholder = { Text(text = "Masukan Password anda") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = { validateRegister() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(49.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Masuk", style = MaterialTheme.typography.button, fontSize = 16.sp)
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Atau",
                textAlign = TextAlign.Center
            )
            Button(
                onClick = { validateRegister() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(49.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, color = MaterialTheme.colors.primary),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                )
            ) {
                Text(text = "Registrasi", style = MaterialTheme.typography.button, fontSize = 16.sp)
            }

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewRegister() {
    RegisterScreen()
}