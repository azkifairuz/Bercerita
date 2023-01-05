package com.javfairuz.bercerita.route

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

import com.javfairuz.bercerita.OnBoardingScreen
import com.javfairuz.bercerita.PageBercerita.BerceritaScreen
import com.javfairuz.bercerita.home.myApp

import com.javfairuz.bercerita.question.PageQuestion
import com.javfairuz.bercerita.question.QuestionContent
import com.javfairuz.bercerita.signin.LoginScreen
import com.javfairuz.bercerita.signin.LoginViewModel
import com.javfairuz.bercerita.signup.RegisterScreen
import com.javfairuz.bercerita.signup.signupViewModel

@Composable
fun RootNav(
    navController: NavHostController,
    signupViewModel: signupViewModel,
    loginViewModel: LoginViewModel
) {
    NavHost(navController = navController, route = Graph.ROOT, startDestination = "onboarding") {
        composable(Graph.HOME) {
            myApp()
        }
        composable(Graph.AUTH) {
            var context = LocalContext.current
            LoginScreen(onLogin = { email, pass ->
                loginViewModel.Login(
                    email,
                    pass
                ) { massage, succes ->
                    if (succes){
                        navController.navigate(Graph.HOME)
                    }else{

                        Toast.makeText(context,massage,Toast.LENGTH_SHORT).show()
                    }
                }
            }, navHostController = navController)
        }
        composable(Graph.ONBOARDING) {
            OnBoardingScreen(navController)
        }
        composable(Graph.QUESTION) {
            PageQuestion(navController)
        }
        composable(Graph.BERCERITA) {
            BerceritaScreen()
        }
        composable(Graph.SIGNUP) {
            var context = LocalContext.current
            RegisterScreen(onSignUp = { nama, email, pass ->
                signupViewModel.RegisterUser(
                    nama,
                    email,
                    pass
                ) { massage, success ->
                    if (success) {
                        navController.navigate(Graph.HOME)
                    } else {
                        Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
                    }
                }
            }, navHostController = navController)
        }
    }

}

object Graph {
    const val HOME = "route_home"
    const val ROOT = "root_graph"
    const val ONBOARDING = "onboarding"
    const val QUESTION = "question"
    const val AUTH = "auth"
    const val SIGNUP = "signup"
    const val BERCERITA = "bercerita"

}
