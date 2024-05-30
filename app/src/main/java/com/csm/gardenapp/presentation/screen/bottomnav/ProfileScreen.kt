package com.csm.gardenapp.presentation.screen.bottomnav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.csm.gardenapp.R
import com.csm.gardenapp.presentation.component.AppIcon
import com.csm.gardenapp.presentation.component.ScreenTitle
import com.csm.gardenapp.presentation.navigation.MainNavigationItem
import com.csm.gardenapp.presentation.viewModel.ProfileScreenViewModel
import com.csm.gardenapp.ui.theme.Green

@Composable
fun ProfileScreen(
    mainNavController: NavHostController,
    viewModel: ProfileScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                ScreenTitle(
                    modifier = Modifier.padding(start = 20.dp),
                    title = stringResource(id = R.string.profile)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 100.dp)
            ) {
                Image(
                    painter = rememberVectorPainter(image = Icons.Outlined.Info),
                    contentDescription = "About us",
                    modifier = Modifier
                        .size(45.dp)
                        .background(Green, RoundedCornerShape(15.dp))
                        .padding(10.dp)
                        .clickable {
                            mainNavController.navigate(MainNavigationItem.AboutUs.route)
                        }
                )

                AppIcon(
                    imageModifier = Modifier
                        .size(120.dp)
                        .padding(10.dp),
                    boxModifier = Modifier.padding(20.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.faq_icon),
                    contentDescription = "Frequently asked questions",
                    modifier = Modifier
                        .size(45.dp)
                        .background(Green, RoundedCornerShape(15.dp))
                        .padding(10.dp)
                        .clickable {
                            mainNavController.navigate(MainNavigationItem.FAQ.route)
                        }
                )
            }
            viewModel.user?.let { user ->
                Text(
                    text = user.username,
                    fontSize = 25.sp
                )

                Text(
                    text = user.email,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(mainNavController = rememberNavController())
}