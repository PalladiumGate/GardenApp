package com.csm.gardenapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.csm.gardenapp.R
import com.csm.gardenapp.presentation.component.StyledButton
import com.csm.gardenapp.presentation.navigation.Screens

@Composable
fun RegisterResultScreen(
    navController: NavController
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.check_mark_icon),
            contentDescription = "Check mark icon"
        )
        Text(
            text = stringResource(id = R.string.registration_successful),
            fontSize = 23.sp,
            modifier = Modifier.padding(top = 15.dp)
        )
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        StyledButton(onClick = {
            navController.navigate(Screens.MAIN.name)
        }) {
            Text(
                text = stringResource(id = R.string.to_main),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = rememberVectorPainter(image = Icons.Outlined.ArrowForward),
                contentDescription = "Next",
                colorFilter = ColorFilter.tint(color = Color.White)
            )
        }
    }
}