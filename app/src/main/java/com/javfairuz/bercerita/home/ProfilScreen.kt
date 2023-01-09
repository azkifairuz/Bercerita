package com.javfairuz.bercerita.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.javfairuz.bercerita.R

@Composable
fun ProfileScreen(
    name: String = "unknown",
    email: String = "unknown@gmail.com",
    universitas: String = "unknown",
    semester: String = "1"
) {
    var nama by remember {
        mutableStateOf(name)
    }

    var email by remember {
        mutableStateOf(email)
    }
    var university by remember {
        mutableStateOf(universitas)
    }
    var tingkat by remember {
        mutableStateOf(semester)
    }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.padding(10.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(5)
        ) {
            Column() {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        backgroundColor =  Color(0xFFA4BE7B)
                    ) {
                      Column(modifier = Modifier.padding(20.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                          Text(
                              text = nama,
                              style = MaterialTheme.typography.body1,
                              fontSize = 30.sp,
                              fontWeight = FontWeight.Bold
                          )
                          Text(
                              text = email,
                              style = MaterialTheme.typography.h1,
                              fontSize = 17.sp
                          )
                      }
                    }

                }
                Spacer(modifier = Modifier.padding(5.dp))
                Column(
                    modifier = Modifier.fillMaxWidth().padding(20.dp)
                ) {
                    Text(
                        text = "Universitas",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = university,
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.subtitle1
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(
                        text = "Semester",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = tingkat,
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileView() {
    ProfileScreen()
}
