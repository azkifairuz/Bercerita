package com.javfairuz.bercerita.route

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.javfairuz.bercerita.home.BottomNavItem
import com.javfairuz.bercerita.home.myApp
import com.javfairuz.bercerita.signin.LoginScreen
import com.javfairuz.bercerita.signup.RegisterScreen
import com.javfairuz.bercerita.viewmodel.AppViewModel

@Composable
fun authNavGraph(navController: NavHostController,
                 viewModel: AppViewModel = AppViewModel()
) {
    NavHost(
        navController = navController,
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
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
        composable(route = AuthScreen.SignUp.route) {
            RegisterScreen(navController)
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")

}