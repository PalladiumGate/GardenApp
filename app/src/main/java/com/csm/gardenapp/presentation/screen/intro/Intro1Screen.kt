package com.csm.gardenapp.presentation.screen.intro

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.csm.gardenapp.R
import com.csm.gardenapp.presentation.component.Intro
import com.csm.gardenapp.presentation.navigation.Screens

@Composable
fun Intro1Screen(
    navController: NavController
) {
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        Intro(
            title = stringResource(id = R.string.directory_title),
            text = stringResource(id = R.string.directory_desc),
            number = 1
        ) {
            navController.navigate(Screens.INTRO2.name)
        }
    }
}