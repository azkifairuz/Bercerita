package com.javfairuz.bercerita.signin


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.R
import com.javfairuz.bercerita.home.BottomApp
import com.javfairuz.bercerita.home.TopApp
import com.javfairuz.bercerita.route.Graph
import com.javfairuz.bercerita.route.HomeNavGraph
import com.javfairuz.bercerita.route.authNavGraph

@Composable
fun auth(navHostController: NavHostController = rememberNavController()) {

    Surface(
     ) {
        authNavGraph(navController = navHostController)
    }
}
@Composable
fun LoginScreen(
    navHostController: NavHostController = rememberNavController(),
        onLogin:(email:String,pass:String) -> Unit = {email,pass -> }
) {
    val context = LocalContext.current
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    fun validateLogin() {
        if (email.text != "" && password.text != "") {
            onLogin(email.text.trim(),password.text.trim())
        } else {
            Toast.makeText(context, "Field Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
        }
    }
    Scaffold(modifier = Modifier.padding(20.dp), topBar = {
        IconButton(onClick = { navHostController.navigate(Graph.ONBOARDING) }) {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
        }
    }) {
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
                text = "Email",
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
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if(passwordVisible) R.drawable.ic_baseline_visibility_24 else R.drawable.ic_baseline_visibility_off_24
                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(painter = painterResource(id = image), contentDescription = description)
                    }
                }
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
                onClick = { navHostController.navigate(Graph.SIGNUP) },
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