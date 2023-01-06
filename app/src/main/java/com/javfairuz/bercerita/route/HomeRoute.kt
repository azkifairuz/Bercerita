package com.javfairuz.bercerita.route

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.javfairuz.bercerita.PageBercerita.BerceritaScreen
import com.javfairuz.bercerita.home.AboutScreen
import com.javfairuz.bercerita.home.BottomNavItem
import com.javfairuz.bercerita.home.Home
import com.javfairuz.bercerita.home.ProfileScreen
import com.javfairuz.bercerita.question.PageQuestion
import com.javfairuz.bercerita.question.question
import com.javfairuz.bercerita.resultTest.PageResultTest

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavItem.Home.screenRoute
    ) {
        composable(route = BottomNavItem.Profile.screenRoute) {
            ProfileScreen()
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
        composable(route = Graph.QUESTION){

            PageQuestion(navController)
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

