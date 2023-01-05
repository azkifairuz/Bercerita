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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.javfairuz.bercerita.question.PageQuestion
import com.javfairuz.bercerita.resultTest.PageResultTest
import com.javfairuz.bercerita.route.RootNav
import com.javfairuz.bercerita.signin.LoginViewModel
import com.javfairuz.bercerita.signup.signupViewModel
import com.javfairuz.bercerita.ui.theme.BerceritaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var signupViewModel: signupViewModel = ViewModelProvider(this)[signupViewModel::class.java]
        var signinViewModel: LoginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        setContent {
            BerceritaTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RootNav(navController = rememberNavController(),signupViewModel,signinViewModel)

                }
            }
        }
    }
}

