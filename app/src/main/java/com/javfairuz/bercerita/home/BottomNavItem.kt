package com.javfairuz.bercerita.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon:ImageVector ,var screenRoute:String){
    object Profile:BottomNavItem("Profile",Icons.Default.Person,"profile")
    object Home:BottomNavItem("Home",Icons.Default.Home,"home")
    object About:BottomNavItem("About",Icons.Default.Info,"about")
}
