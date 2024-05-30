package com.csm.gardenapp.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.csm.gardenapp.R
import com.csm.gardenapp.presentation.component.AppIcon
import com.csm.gardenapp.presentation.component.PasswordTextField
import com.csm.gardenapp.presentation.component.StyledButton
import com.csm.gardenapp.presentation.component.StyledTextField
import com.csm.gardenapp.presentation.navigation.Screens
import com.csm.gardenapp.presentation.viewModel.LoginScreenViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppIcon()
                Spacer(Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.login_to_acc),
                    fontSize = 30.sp
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .border(width = 0.5.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                viewModel.error?.let {
                    Text(
                        text = it,
                        color = Color.Red,
                        fontSize = 19.sp
                    )
                    Spacer(Modifier.height(10.dp))
                }

                StyledTextField(
                    placeHolder = stringResource(id = R.string.email),
                    text = viewModel.email, 
                    onValueChange = viewModel::updateEmail
                )

                PasswordTextField(
                    placeHolder = stringResource(id = R.string.password),
                    text = viewModel.password,
                    onValueChange = viewModel::updatePassword
                )
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StyledButton(onClick = {
                    viewModel.login {
                        navController.navigate(Screens.MAIN.name)
                    }
                }) {
                    Text(
                        text = stringResource(id = R.string.login),
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
                Text(
                    text = stringResource(id = R.string.no_account),
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .clickable {
                            navController.navigate(Screens.SIGNUP.name)
                        }
                )
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}