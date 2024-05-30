package com.csm.gardenapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.csm.gardenapp.R
import com.csm.gardenapp.domain.model.Plant
import com.csm.gardenapp.ui.theme.Grey

@Composable
fun PlantItem(
    modifier: Modifier = Modifier,
    plant: Plant,
    showPlantDays: Boolean = false //показывать ли дни, в которые нужно сажать
) {
    Row(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .background(color = Grey, shape = RoundedCornerShape(15.dp))
            .padding(vertical = 7.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PlantImage(
            imageUrl = plant.imageUrl
        )
        if (showPlantDays) {
            Column {
                Text(
                    text = plant.name,
                    fontSize = 23.sp,
                    modifier = Modifier.padding(start = 50.dp)
                )

                Text(
                    text = plant.dayPeriod,
                    fontSize = 21.sp,
                    modifier = Modifier.padding(start = 50.dp)
                )
            }
        } else {
            Text(
                text = plant.name,
                fontSize = 23.sp,
                modifier = Modifier.padding(start = 50.dp)
            )
        }
    }
}

@Composable
fun PlantImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    if (imageUrl.isEmpty()) {
        Image(
            painter = painterResource(id = R.drawable.garden_app_icon),
            contentDescription = "Картинка профиля",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                .padding(15.dp)
                .size(45.dp)
        )
    } else {
        // используем специальный компонент, в который мы можем загрузить изображение из интернета
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.garden_app_icon),
            contentDescription = "Картинка растения",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                .padding(15.dp)
                .size(45.dp)
        )
    }
}

@Composable
@Preview
fun PlantItemPreview() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        PlantItem(plant = Plant(
            name = "Plant1", month = "January",
            dayPeriod = "12-13",
            imageUrl = "",
            description = "Image for test"
        ))
    }
}

@Composable
@Preview
fun PlantItemPreview2() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        PlantItem(plant = Plant(
            name = "Plant1", month = "January",
            dayPeriod = "12-13",
            imageUrl = "",
            description = "Image for test"
        ), showPlantDays = true)
    }
}