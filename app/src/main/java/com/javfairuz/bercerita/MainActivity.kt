package com.javfairuz.bercerita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.javfairuz.bercerita.question.PageQuestion
import com.javfairuz.bercerita.resultTest.PageResultTest
import com.javfairuz.bercerita.ui.theme.BerceritaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BerceritaTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "OnBoarding") {
                        composable("register") {
                            RegisterScreen(navHostController = navController)
                        }
                        composable("myapp"){

                            myApp(navController)

                        }
                        composable("login") {
                            LoginScreen(navHostController = navController)
                        }
                        composable("home"){
                            MainPage(navHostController = navController)
                        }
                        composable("OnBoarding"){
                            OnBoardingScreen(navHostController = navController)
                        }

                        composable("question"){
                            PageQuestion(navHostController = navController)
                        }

                        composable(
                            "result/{score}",
                            arguments = listOf(
                                navArgument(
                                    name = "score"
                                ) {
                                    NavType.IntType
                                }
                            )
                        ){
                            PageResultTest(
                                navHostController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun myApp(navHostController: NavHostController = rememberNavController()) {
    Scaffold(bottomBar = {
        BottomNavigation() {
            BottomNavigationItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.White
                    )
                },
                label = { Text(text = "profile") }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Profile",
                        tint = Color.White
                    )
                },
                label = { Text(text = "Beranda") }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Profile",
                        tint = Color.White
                    )
                },
                label = { Text(text = "About") }
            )
        }
    }) {
        MainPage(navHostController = navHostController)
    }
}

@Composable
fun MainPage(navHostController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(horizontal = 25.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.Header), style = MaterialTheme.typography.h1, fontSize = 30.sp)
        Text(
            text = "Mengenal diri Lebih dalam",
            style = MaterialTheme.typography.body1,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = stringResource(id = R.string.Sub), style = MaterialTheme.typography.subtitle1)
        Button(
            modifier = Modifier
                .width(150.dp)
                .padding(vertical = 10.dp),
            onClick = { navHostController.navigate("question")},
            shape = RoundedCornerShape(50),
        ) {
            Text(text = "Mulai", style = MaterialTheme.typography.button)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Baca Panduan Pengisiannya, yul!",
            style = MaterialTheme.typography.h1,
            fontSize = 18.sp
        )
        Column(modifier = Modifier.padding(start = 15.dp)) {

            Text(
                text = "1. Gak ada jawaban yang benar atau salah, isilah dengan jujur sesuai kepribaanmu",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "2. Santai aja, tes ini gak diberi waktu",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "3. Cari tempat yang nyaman dan kondusif supaya kamu lebih fokus",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "4. Jika kamu Keluar di tengah jalan, maka seluruh proses tes dan jawaban akan hilang",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "5. Hasil tes bisa kamu dapatkan setelah mengisi semua pertanyaan dengan lengkap",
                style = MaterialTheme.typography.subtitle1
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BerceritaTheme {
        Scaffold(bottomBar = {
            BottomNavigation() {
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = Color.White
                        )
                    },
                    label = { Text(text = "profile") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Profile",
                            tint = Color.White
                        )
                    },
                    label = { Text(text = "Beranda") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Profile",
                            tint = Color.White
                        )
                    },
                    label = { Text(text = "About") }
                )
            }
        }) {
            MainPage()
        }
    }
}