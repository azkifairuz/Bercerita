package com.javfairuz.bercerita.route

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.javfairuz.bercerita.OnBoardingScreen
import com.javfairuz.bercerita.PageBercerita.BerceritaScreen
import com.javfairuz.bercerita.home.*
import com.javfairuz.bercerita.models.DataState
import com.javfairuz.bercerita.question.PageQuestion
import com.javfairuz.bercerita.question.question
import com.javfairuz.bercerita.resultTest.PageResultTest
import com.javfairuz.bercerita.signin.LoginScreen
import com.javfairuz.bercerita.viewmodel.AppViewModel

@Composable
fun HomeNavGraph(
    navController: NavHostController, viewModel: AppViewModel = AppViewModel()
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavItem.Home.screenRoute
    ) {
        composable(route = BottomNavItem.Profile.screenRoute) {
            val dataState by viewModel.state
            LaunchedEffect(
                key1 = viewModel,
                block = {
                    viewModel.getDataUser()
                }
            )
            val context = LocalContext.current
            ProfileScreen(
                onLogout = {
                    viewModel.logout() { massage, success ->
                        if (success) {
                            Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
                            navController.navigate(Graph.ROOT)
                        } else {
                            Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                dataState = dataState
            )
        }
        composable(route = Graph.ROOT) {
            LoginScreen(navHostController = navController)
        }
        composable(route = BottomNavItem.Home.screenRoute) {
            Home(navController)
        }
        composable(route = BottomNavItem.About.screenRoute) {
            AboutScreen()
        }
        composable(route = Graph.BERCERITA) {
            BerceritaScreen()
        }
        composable(route = Graph.QUESTION) {
            PageQuestion(navController)
        }
        composable(Graph.ARIGATOU){
            ArigatouScreen(viewModel.user.orEmpty(),navController)
        }
        composable(
            route = "result/{score}",
            arguments = listOf(
                navArgument(name = "score") { NavType.IntType }
            )
        ) {
            val context = LocalContext.current
            PageResultTest(
                navHostController = navController,
            onSubmit = {stressMeter ->
                viewModel.pushResult(stressMeter){ massage,success ->
                    if (success){
                        Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
                    }

                }
            })
        }
    }
}

//fun NavGraphBuilder.questionNavGraph(navController: NavHostController) {
//    navigation(
//        route = Graph.QUESTION,
//        startDestination = QuestionScreen.Question.route
//    ) {
//        composable(route = QuestionScreen.Question.route) {
//            PageQuestion(navController)
//        }
//    }
//}
//
//sealed class QuestionScreen(val route: String) {
//    object Question : QuestionScreen(route = "QUESTION")
//}

