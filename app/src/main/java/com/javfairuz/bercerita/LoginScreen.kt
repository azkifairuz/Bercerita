package com.javfairuz.bercerita

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.ui.theme.Shapes


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

    fun validateLogin() {
        if (username.text == "azki") {
            navHostController.navigate("myapp") {
                popUpTo("login") { inclusive = true }
            }
        } else {
            Toast.makeText(context, "Username salah", Toast.LENGTH_SHORT).show()
        }
    }
    Scaffold(modifier = Modifier.padding(20.dp),
        topBar = {
            IconButton(onClick = { navHostController.navigate("onboarding") }) {
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
                text = "Masuk",
                style = MaterialTheme.typography.h1,
                fontSize = 32.sp,
                fontWeight = W700,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Username",
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
                onClick = { validateLogin() },
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
                onClick = { navHostController.navigate("register") },
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
fun PreviewLogin() {
    LoginScreen()
}