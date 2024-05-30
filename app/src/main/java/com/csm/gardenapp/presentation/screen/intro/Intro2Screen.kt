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
fun Intro2Screen(
    navController: NavController
) {
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        Intro(
            title = stringResource(id = R.string.calendar_title),
            text = stringResource(id = R.string.calendar_desc),
            number = 2,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            navController.navigate(Screens.INTRO3.name)
        }
    }
}