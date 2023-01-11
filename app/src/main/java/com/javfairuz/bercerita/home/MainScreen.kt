package com.javfairuz.bercerita.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.route.HomeNavGraph


@Composable
fun myApp(navHostController: NavHostController = rememberNavController()) {

    Scaffold(
        topBar = {
        TopApp()

        },
        bottomBar = {
            BottomApp(navHostController = navHostController)

        }) {
        HomeNavGraph(navController = navHostController)
    }
}


@Composable
fun TopApp(){
    TopAppBar(modifier = Modifier.fillMaxWidth(),backgroundColor = Color(0xFFA4BE7B)){
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("Bercerita", textAlign = TextAlign.Center, fontSize = 20.sp)
        }
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
            BottomNavigation(
                backgroundColor = Color.White
            ) {
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
        selectedContentColor = MaterialTheme.colors.primary,
        unselectedContentColor = MaterialTheme.colors.primary.copy(alpha = ContentAlpha.disabled),
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