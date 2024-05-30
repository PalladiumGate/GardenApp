package com.csm.gardenapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csm.gardenapp.R
import com.csm.gardenapp.ui.theme.Green

@Composable
fun AppIcon(
    boxModifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier
) {
    Box (
        modifier = boxModifier
            .background(Color.White, CircleShape)
            .border(width = 0.5.dp, color = Color.Black, shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.garden_app_icon),
            contentDescription = "App icon",
            modifier = imageModifier.clip(CircleShape).padding(10.dp)
        )
    }
}

@Composable
fun ScreenTitle(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        text = title,
        modifier = modifier
            .background(color = Green, shape = RoundedCornerShape(13.dp))
            .padding(10.dp),
        fontSize = 23.sp
    )
}

@Composable
@Preview(showBackground = false)
fun AppIconPreview() {
    AppIcon()
}
