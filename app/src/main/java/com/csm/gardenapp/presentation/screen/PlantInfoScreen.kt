package com.csm.gardenapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csm.gardenapp.domain.model.Plant
import com.csm.gardenapp.presentation.component.PlantImage

@Composable
fun PlantInfoScreen(
    plant: Plant
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedCard(
                modifier = Modifier.padding(top = 80.dp)
            ) {
                PlantImage(
                    imageUrl = plant.imageUrl,
                    modifier = Modifier.size(150.dp)
                )
            }
            
            Text(
                text = plant.name,
                fontSize = 28.sp,
                modifier = Modifier.padding(top = 30.dp)
            )
            
            Text(
                text = plant.description,
                fontSize = 23.sp,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

@Composable
@Preview
fun PlantInfoScreenPreview() {
    PlantInfoScreen(plant = Plant(
        "test",
        "Январь",
        "12-15",
        "",
        "Описание Описание Описание Описание Описание Описание Описание Описание Описание "))
}