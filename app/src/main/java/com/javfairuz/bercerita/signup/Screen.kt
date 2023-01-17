package com.javfairuz.bercerita.signup


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius.Companion.Zero
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize.Companion.Zero
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.R
import com.javfairuz.bercerita.route.Graph

@Composable
fun RegisterScreen(
    navHostController: NavHostController = rememberNavController(),
    onSignUp: (nama: String, email: String, pass: String) -> Unit = { nama, email, pass -> }
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
    var passwordVisible by rememberSaveable { mutableStateOf(false) }




    fun validateRegister() {
        if (username.text != "" && email.text != "" && password.text != "") {
            onSignUp(username.text.trim(), email.text.trim(), password.text.trim())

        } else (Toast.makeText(context, "field tidak boleh kosong", Toast.LENGTH_SHORT).show())
    }
    Scaffold(modifier = Modifier.padding(20.dp), topBar = {
        IconButton(onClick = { navHostController.navigate("login") }) {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
        }
    }) {
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
            Row(modifier = Modifier) {
                Text(
                    text = "Sudah Punya Akun?",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "Login",
                    modifier = Modifier.clickable { navHostController.navigate(Graph.AUTH) },
                    color = Color.Blue,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1
                )
            }
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
                singleLine = true,
                onValueChange = { username = it },
                placeholder = { Text(text = "Masukan Username  anda") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),

            )

            Spacer(modifier = Modifier.padding(8.dp))





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
                onClick = { validateRegister() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(49.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Simpan", style = MaterialTheme.typography.button, fontSize = 16.sp)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewRegister() {
    RegisterScreen()
}