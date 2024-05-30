package com.csm.gardenapp.presentation.screen.bottomnav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.csm.gardenapp.R
import com.csm.gardenapp.domain.model.Note
import com.csm.gardenapp.presentation.component.MaterialLoadingDialog
import com.csm.gardenapp.presentation.component.NoteItem
import com.csm.gardenapp.presentation.component.ScreenTitle
import com.csm.gardenapp.presentation.navigation.BottomNavItem
import com.csm.gardenapp.presentation.navigation.MainNavigationItem
import com.csm.gardenapp.presentation.viewModel.NotesScreenViewModel
import com.csm.gardenapp.ui.theme.Green

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NotesScreen(
    mainNavController: NavHostController,
    viewModel: NotesScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = viewModel.loadingState,
        onRefresh = viewModel::loadNotes
    )
    LaunchedEffect(Unit) {
        viewModel.loadNotes()
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                mainNavController.currentBackStackEntry?.savedStateHandle?.set(
                    "note",
                    Note("", "", "", "")
                )
                mainNavController.navigate(MainNavigationItem.Note.route)
            },modifier = Modifier.padding(end = 20.dp, bottom = 30.dp),
                containerColor = Green) {
                Image(
                    painter = rememberVectorPainter(image = Icons.Outlined.Add),
                    contentDescription = "Add icon"
                )
            }
        }
    ) {padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(pullRefreshState)
        ){
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {
                    ScreenTitle(
                        modifier = Modifier.padding(start = 20.dp),
                        title = stringResource(id = R.string.notes)
                    )
                }

                LazyColumn {
                    items(viewModel.notes) {note ->
                        NoteItem(
                            note = note,
                            modifier = Modifier.padding(top = 15.dp)
                        ) {
                            mainNavController.currentBackStackEntry?.savedStateHandle?.set(
                                "note",
                                note
                            )
                            mainNavController.navigate(MainNavigationItem.Note.route)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun NotesScreenPreview() {
    NotesScreen(rememberNavController())
}