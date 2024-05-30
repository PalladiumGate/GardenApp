package com.csm.gardenapp.presentation.screen.bottomnav

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.csm.gardenapp.R
import com.csm.gardenapp.presentation.component.PlantItem
import com.csm.gardenapp.presentation.component.ScreenTitle
import com.csm.gardenapp.presentation.navigation.MainNavigationItem
import com.csm.gardenapp.presentation.viewModel.DirectoryScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DirectoryScreen(
    mainNavController: NavHostController,
    viewModel: DirectoryScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
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
                    title = stringResource(id = R.string.directory)
                )
            }

            SearchBar(
                modifier = Modifier
                    .padding(top = 20.dp),
                query = viewModel.query,
                onQueryChange = viewModel::onQueryChange,
                onSearch = {
                    viewModel.filter(it)
                },
                active = true,
                onActiveChange = {}
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
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
}

@Composable
@Preview
fun DirectoryScreenPreview() {
    DirectoryScreen(mainNavController = rememberNavController())
}