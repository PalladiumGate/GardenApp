package com.csm.gardenapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.csm.gardenapp.presentation.navigation.BottomNavHost
import com.csm.gardenapp.presentation.navigation.BottomNavItem
import com.csm.gardenapp.presentation.navigation.Screens
import com.csm.gardenapp.ui.theme.Green

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    val items = mutableListOf(
        BottomNavItem.Directory,
        BottomNavItem.Calendar,
        BottomNavItem.Notes,
        BottomNavItem.Profile
    )
    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            BottomNavigation (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .border(width = 0.5.dp, color = Color.Black, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                backgroundColor = Color.White
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach {item ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label
                            )
                        },
                        selectedContentColor = Green,
                        unselectedContentColor = Color.Black,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }
        }
    ) {
        BottomNavHost(
            modifier = Modifier.padding(it),
            mainNavController = navHostController,
            bottomNavController = navController
        )
    }
}