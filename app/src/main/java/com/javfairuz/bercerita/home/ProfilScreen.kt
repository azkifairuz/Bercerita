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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
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
    universitas: String = "unknown",
    semester: String = "1"
) {
    var nama by remember {
        mutableStateOf(name)
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
            backgroundColor = Color(0xFFA4BE7B),
            elevation = 10.dp,
            shape = RoundedCornerShape(20)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = nama,
                        style = MaterialTheme.typography.body1,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row() {
                    Text(
                        text = "Adalah mahasiswa dari kampus $university dan sekarang menginjak semester $tingkat",
                        textAlign = TextAlign.Center,
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
