package com.javfairuz.bercerita.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.javfairuz.bercerita.home.AboutScreen
import com.javfairuz.bercerita.home.BottomNavItem
import com.javfairuz.bercerita.home.Home
import com.javfairuz.bercerita.home.ProfileScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavItem.Home.screenRoute
    ) {
            composable(route = BottomNavItem.Profile.screenRoute){
                    ProfileScreen()
            }
            composable(route = BottomNavItem.Home.screenRoute){
                    Home()
            }
            composable(route = BottomNavItem.Profile.screenRoute){
                    AboutScreen()
            }
    }
}

