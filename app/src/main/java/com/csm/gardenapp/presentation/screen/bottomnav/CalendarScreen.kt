package com.csm.gardenapp.presentation.screen.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.monthpickercompose.MonthPickerDialog
import com.csm.gardenapp.R
import com.csm.gardenapp.domain.util.mapMonthRusEng
import com.csm.gardenapp.presentation.component.PlantItem
import com.csm.gardenapp.presentation.component.ScreenTitle
import com.csm.gardenapp.presentation.navigation.MainNavigationItem
import com.csm.gardenapp.presentation.viewModel.CalendarScreenViewModel
import com.csm.gardenapp.ui.theme.Green
import com.csm.gardenapp.ui.theme.Grey
import java.text.SimpleDateFormat
import java.util.Calendar

@Composable
fun CalendarScreen(
    mainNavController: NavHostController,
    viewModel: CalendarScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    if (viewModel.openDialog) {
        MonthPickerDialog(
            onCancel = { viewModel.openDialog = false },
            onUpdateMonth = { month, year ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.YEAR, year)

                viewModel.openDialog = false
                viewModel.selectMonth(" ${
                    SimpleDateFormat("MMMM").format(calendar.time)
                }")
            },
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (viewModel.plants.isEmpty()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Нет посадок в этом месяце", fontSize = 26.sp)
            }
        }
        
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
                    title = stringResource(id = R.string.calendar)
                )
            }

            Box(
                modifier = Modifier
                    .padding(30.dp)
                    .background(Grey, RoundedCornerShape(15.dp))
                    .padding(vertical = 10.dp, horizontal = 40.dp)
                    .clickable {
                        viewModel.openDialog = true
                    }
            ) {
                Text(
                    text = viewModel.selectedMonth,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 23.sp,
                    color = Green
                )
            }

            LazyColumn {
                items(viewModel.plants) {plant ->
                    PlantItem(
                        plant = plant,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .clickable {
                                mainNavController.currentBackStackEntry?.savedStateHandle?.set(
                                    "plant",
                                    plant
                                )
                                mainNavController.navigate(MainNavigationItem.PlantInfo.route)
                            }
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun CalendarScreenPreview() {
    CalendarScreen(mainNavController = rememberNavController())
}