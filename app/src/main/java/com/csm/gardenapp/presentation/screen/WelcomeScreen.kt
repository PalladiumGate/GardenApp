package com.csm.gardenapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.csm.gardenapp.R
import com.csm.gardenapp.presentation.component.AppIcon
import com.csm.gardenapp.presentation.component.ButtonNext
import com.csm.gardenapp.presentation.navigation.Screens
import com.csm.gardenapp.presentation.viewModel.WelcomeScreenViewModel

@Composable
fun WelcomeScreen(
    navController: NavController,
    wViewModel: WelcomeScreenViewModel = viewModel()
) {
    wViewModel.checkIfLoggedIn { navController.navigate(Screens.MAIN.name) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppIcon(
                        boxModifier = Modifier.padding(start = 20.dp),
                    )

                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontSize = 35.sp,
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(end = 40.dp)
                    )
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.garden_welcome_image),
                        contentDescription = "Welcome image",
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 100.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.welcome),
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top = 70.dp)
                )

                ButtonNext(
                    modifier = Modifier.padding(top = 50.dp)
                ) {
                    navController.navigate(Screens.INTRO1.name)
                }
            }
        }

    }
}

@Composable
@Preview
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}