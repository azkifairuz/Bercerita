package com.javfairuz.bercerita.home

import androidx.compose.foundation.layout.RowScope
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
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
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
fun BottomApp(navHostController: NavHostController) {
    val screen = listOf(
        BottomNavItem.Profile,
        BottomNavItem.Home,
        BottomNavItem.About,
    )
    BottomNavigation {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination

        val bottomBarDestination = screen.any { it.screenRoute == currentRoute?.route }
        if (bottomBarDestination) {
            BottomNavigation() {
                screen.forEach { screens ->
                    AddItem(
                        screen = screens,
                        currentDestination = currentRoute,
                        navController = navHostController
                    )

                }
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.screenRoute
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.screenRoute) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMain() {
    myApp()
}