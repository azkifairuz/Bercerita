package com.javfairuz.bercerita.home

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javfairuz.bercerita.models.DataState
import com.javfairuz.bercerita.models.DataUser


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ProfileScreen(
    email: String = "unknown@gmail.com",
    onLogout: () -> Unit = { },

    dataState: DataState = DataState.Empty
) {
    val activity = (LocalContext.current as? Activity)
    fun exit() {
        activity?.finish()
        onLogout()
    }

    val emails by remember {
        mutableStateOf(email)
    }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .height(250.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(5)
        ) {
            when (val result = dataState) {
                DataState.Empty -> {
                    Text(text = "kosong")
                }
                is DataState.Failure -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = result.msg, style = MaterialTheme.typography.body1)

                    }
                }
                DataState.Loading -> {
                    ProgressDialog()
                }
                is DataState.Success -> {
                    SuccesScreen(dataUser = result.data, email = emails)
                }

            }

        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = {
                exit()
            }, modifier = Modifier
                .width(200.dp)
                .padding(10.dp), shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Logout")
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Preview
@Composable
fun ProgressDialog() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}


@Composable
fun SuccesScreen(
    dataUser: MutableList<DataUser>,
    email: String = "unknown"
) {
    LazyColumn {
        items(dataUser) { each ->
            item(user = each, email = email)
        }

    }

}

@Composable
fun item(user: DataUser, email: String) {
    Column() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color(0xFFA4BE7B)
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = user.nama,
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "Universitas",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = user.universitas,
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
                text = user.semester,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.subtitle1
            )

        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileView() {
    ProfileScreen()
}
