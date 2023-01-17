package com.javfairuz.bercerita.home

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.javfairuz.bercerita.route.Graph

@Composable
fun ArigatouScreen(name: String = "", navHostController: NavHostController) {

    var nama by remember { mutableStateOf(name) }
    val activity = (LocalContext.current as? Activity)
    fun exit() {
        activity?.finish()

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Terimakasih azki", style = MaterialTheme.typography.body1,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Row() {
            Button(onClick = {
                exit()
            }) {
                Text(text = "Keluar", style = MaterialTheme.typography.button)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            OutlinedButton(onClick = {
                navHostController.navigate(Graph.HOME)
            }) {
                Text(text = "Home", style = MaterialTheme.typography.button)

            }
        }
    }

}