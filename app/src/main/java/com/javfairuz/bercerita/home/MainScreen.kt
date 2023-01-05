package com.javfairuz.bercerita.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.route.HomeNavGraph




@Composable
fun myApp(navHostController: NavHostController = rememberNavController()) {

    Scaffold(bottomBar = {
        BottomApp(navHostController = navHostController)

    }) {
        HomeNavGraph(navController = navHostController)
    }
}

@Composable
fun BottomApp(navHostController: NavHostController){
    val screen = listOf(
        BottomNavItem.Profile,
        BottomNavItem.Home,
        BottomNavItem.About,
    )
    BottomNavigation {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        screen.forEach{ items ->
            BottomNavigationItem(
                icon = { Icon(imageVector = items.icon,"Content description") },
                label = { Text(text = items.title)},
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                selected = currentRoute == items.screenRoute,
                onClick = {
                    navHostController.navigate(items.screenRoute){
                        navHostController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                }
            )

        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMain(){
    myApp()
}