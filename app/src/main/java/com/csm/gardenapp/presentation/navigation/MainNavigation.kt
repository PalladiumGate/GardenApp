package com.csm.gardenapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.csm.gardenapp.R
import com.csm.gardenapp.domain.model.Note
import com.csm.gardenapp.domain.model.Plant
import com.csm.gardenapp.presentation.screen.AboutUsScreen
import com.csm.gardenapp.presentation.screen.FaqScreen
import com.csm.gardenapp.presentation.screen.intro.Intro1Screen
import com.csm.gardenapp.presentation.screen.intro.Intro2Screen
import com.csm.gardenapp.presentation.screen.intro.Intro3Screen
import com.csm.gardenapp.presentation.screen.LoginScreen
import com.csm.gardenapp.presentation.screen.MainScreen
import com.csm.gardenapp.presentation.screen.NoteScreen
import com.csm.gardenapp.presentation.screen.PlantInfoScreen
import com.csm.gardenapp.presentation.screen.RegisterResultScreen
import com.csm.gardenapp.presentation.screen.RegisterScreen
import com.csm.gardenapp.presentation.screen.WelcomeScreen
import com.csm.gardenapp.presentation.screen.bottomnav.CalendarScreen
import com.csm.gardenapp.presentation.screen.bottomnav.DirectoryScreen
import com.csm.gardenapp.presentation.screen.bottomnav.NotesScreen
import com.csm.gardenapp.presentation.screen.bottomnav.ProfileScreen

enum class Screens {
    WELCOME,
    INTRO1,
    INTRO2,
    INTRO3,
    LOGIN,
    SIGNUP,
    SIGNUP_RESULT,
    MAIN,
    PLANT_INFO,
    NOTE,
    ABOUT_US,
    FAQ,
    DIRECTORY,
    CALENDAR,
    NOTES,
    PROFILE
}

sealed class MainNavigationItem(val route: String) {
    data object Welcome : MainNavigationItem(Screens.WELCOME.name)
    data object Intro1 : MainNavigationItem(Screens.INTRO1.name)
    data object Intro2 : MainNavigationItem(Screens.INTRO2.name)
    data object Intro3 : MainNavigationItem(Screens.INTRO3.name)
    data object Login : MainNavigationItem(Screens.LOGIN.name)
    data object Signup : MainNavigationItem(Screens.SIGNUP.name)
    data object SignupResult : MainNavigationItem(Screens.SIGNUP_RESULT.name)
    data object Main : MainNavigationItem(Screens.MAIN.name)
    data object PlantInfo : MainNavigationItem(Screens.PLANT_INFO.name)
    data object Note : MainNavigationItem(Screens.NOTE.name)
    data object AboutUs : MainNavigationItem(Screens.ABOUT_US.name)
    data object FAQ : MainNavigationItem(Screens.FAQ.name)
}

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    data object Directory: BottomNavItem(Screens.DIRECTORY.name, R.drawable.directory_icon, "Directory")
    data object Calendar: BottomNavItem(Screens.CALENDAR.name, R.drawable.calendar_icon, "Calendar")
    data object Notes: BottomNavItem(Screens.NOTES.name, R.drawable.notes_icon, "Notes")
    data object Profile: BottomNavItem(Screens.PROFILE.name, R.drawable.profile_bottom_icon, "Profile")
}

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = MainNavigationItem.Welcome.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainNavigationItem.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(MainNavigationItem.Intro1.route) {
            Intro1Screen(navController = navController)
        }
        composable(MainNavigationItem.Intro2.route) {
            Intro2Screen(navController = navController)
        }
        composable(MainNavigationItem.Intro3.route) {
            Intro3Screen(navController = navController)
        }
        composable(MainNavigationItem.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(MainNavigationItem.Signup.route) {
            RegisterScreen(navController = navController)
        }
        composable(MainNavigationItem.SignupResult.route) {
            RegisterResultScreen(navController = navController)
        }
        composable(MainNavigationItem.Main.route) {
            MainScreen(navHostController = navController)
        }
        composable(MainNavigationItem.PlantInfo.route) {
            val plant = navController.previousBackStackEntry?.savedStateHandle?.get<Plant>("plant")
            plant?.let {
                PlantInfoScreen(plant = it)
            }
        }
        composable(MainNavigationItem.Note.route) {
            val note = navController.previousBackStackEntry?.savedStateHandle?.get<Note>("note")
            note?.let {
                NoteScreen(mainNavController = navController, note = it)
            }
        }
        composable(MainNavigationItem.AboutUs.route) {
            AboutUsScreen()
        }
        composable(MainNavigationItem.FAQ.route) {
            FaqScreen()
        }
    }
}

@Composable
fun BottomNavHost(
    modifier: Modifier = Modifier,
    mainNavController: NavHostController,
    bottomNavController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = bottomNavController,
        route = MainNavigationItem.Main.route,
        startDestination = BottomNavItem.Directory.route
    ) {
        composable(BottomNavItem.Directory.route) {
            DirectoryScreen(mainNavController = mainNavController)
        }
        composable(BottomNavItem.Calendar.route) {
            CalendarScreen(mainNavController = mainNavController)
        }
        composable(BottomNavItem.Notes.route) {
            NotesScreen(mainNavController = mainNavController)
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen(mainNavController = mainNavController)
        }
    }
}