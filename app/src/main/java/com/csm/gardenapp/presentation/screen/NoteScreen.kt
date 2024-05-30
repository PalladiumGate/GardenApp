package com.csm.gardenapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.csm.gardenapp.R
import com.csm.gardenapp.domain.model.Note
import com.csm.gardenapp.presentation.component.MaterialLoadingDialog
import com.csm.gardenapp.presentation.component.ScreenTitle
import com.csm.gardenapp.presentation.component.StyledButton
import com.csm.gardenapp.presentation.navigation.MainNavigationItem
import com.csm.gardenapp.presentation.viewModel.NoteScreenViewModel
import com.csm.gardenapp.ui.theme.Green
import com.csm.gardenapp.ui.theme.Grey

@Composable
fun NoteScreen(
    mainNavController: NavHostController,
    note: Note,
    viewModel: NoteScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var noteText by remember {
        mutableStateOf(note.text)
    }
    var noteTitle by remember {
        mutableStateOf(note.name)
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MaterialLoadingDialog(showDialog = viewModel.loadingState)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Image(
                    painter = rememberVectorPainter(image = Icons.AutoMirrored.Outlined.ArrowBack),
                    contentDescription = "Back btn",
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .clickable {
                            mainNavController.popBackStack()
                        }
                )

                ScreenTitle(
                    modifier = Modifier.padding(start = 90.dp),
                    title = "Заметка"
                )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                viewModel.error?.let {
                    Text(
                        text = it,
                        color = Color.Red,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }

                TextField(
                    label = {
                        Text(text = "Заголовок заметки")
                    },
                    modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                    value = noteTitle,
                    onValueChange = {
                        noteTitle = it
                    })

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp)),
                    label = {
                        Text(text = "Текст заметки")
                    },
                    value = noteText,
                    onValueChange = {
                        noteText = it
                    }
                )
            }

            StyledButton(onClick = {
                note.name = noteTitle
                note.text = noteText

                viewModel.createUpdNote(note) {
                    mainNavController.popBackStack()
                }
            }, modifier = Modifier.padding(bottom = 30.dp)) {
                Row {
                    Text(text = "Сохранить", fontSize = 22.sp)
                    Image(
                        painter = rememberVectorPainter(image = Icons.Default.Check),
                        contentDescription = "Save icon", 
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun NoteScreenPreview(){
    NoteScreen(rememberNavController(), Note("11", "Note 1", "12.11.2022", "Hello!!"))
}