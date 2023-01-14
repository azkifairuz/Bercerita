package com.javfairuz.bercerita.route

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import com.javfairuz.bercerita.OnBoardingScreen
import com.javfairuz.bercerita.PageBercerita.BerceritaScreen
import com.javfairuz.bercerita.completeprofile.CompleteProfileScreen
import com.javfairuz.bercerita.home.myApp
import com.javfairuz.bercerita.question.PageQuestion
import com.javfairuz.bercerita.question.QuestionContent
import com.javfairuz.bercerita.signin.LoginScreen
import com.javfairuz.bercerita.signup.RegisterScreen
import com.javfairuz.bercerita.viewmodel.AppViewModel

@Composable
fun RootNav(
    navController: NavHostController,
    viewModel: AppViewModel,
) {
    NavHost(navController = navController, route = Graph.ROOT, startDestination = "onboarding") {
        composable(Graph.HOME) {
            myApp()
        }
        composable(Graph.AUTH) {
            var user = Firebase.auth.currentUser
            var context = LocalContext.current
            if (user !=null){
                myApp()
            }else{
                LoginScreen(onLogin = { email, pass ->
                    viewModel.Login(
                        email,
                        pass
                    ) { massage, succes ->
                        if (succes) {
                            navController.navigate(Graph.HOME)
                        } else {

                            Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
                        }
                    }
                }, navHostController = navController)
            }

        }
        composable(Graph.ONBOARDING) {
            var user = Firebase.auth.currentUser
            var context = LocalContext.current
            if (user != null){
                myApp()
            }else{
                OnBoardingScreen(navController)
            }

        }
        composable(Graph.QUESTION) {
            PageQuestion(navController)
        }
        composable(Graph.BERCERITA) {
            BerceritaScreen()
        }
        composable(Graph.SIGNUP) {
            val context = LocalContext.current
            RegisterScreen(onSignUp = { nama, email, pass ->
                viewModel.RegisterUser(
                    nama,
                    email,
                    pass
                ) { massage, success ->
                    if (success) {
                        navController.navigate(Graph.COMPLETE)
                    } else {
                        Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
                    }
                }
            }, navHostController = navController)
        }
        composable(Graph.COMPLETE){
            val context = LocalContext.current
            CompleteProfileScreen(
                navHostController = navController,
                onSubmit = {univ,semester ->
                    viewModel.pushData(
                        univ,
                        semester
                    ){ massage, succes ->
                        if (succes){
                            navController.navigate(Graph.HOME)
                        }else{
                            Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            )
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
    const val COMPLETE = "complete"


}
