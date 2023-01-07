package com.javfairuz.bercerita.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon:ImageVector ,var screenRoute:String){
    object Profile:BottomNavItem("Profile",Icons.Outlined.Person,"profile")
    object Home:BottomNavItem("Home",Icons.Outlined.Home,"home")
    object About:BottomNavItem("About",Icons.Outlined.Info,"about")
}
