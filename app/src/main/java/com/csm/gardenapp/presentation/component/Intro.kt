package com.csm.gardenapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csm.gardenapp.ui.theme.Green

@Composable
fun Intro(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    number: Int, // 1, 2, 3
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, 
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row (
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            AppIcon(boxModifier = Modifier.padding(start = 20.dp))
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .border(width = 0.5.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = text,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Box(modifier = Modifier
                    .size(10.dp)
                    .background(
                        color = if (number == 1) Green else Color.Gray,
                        shape = CircleShape
                    ))
                Spacer(modifier = Modifier.width(5.dp))
                Box(modifier = Modifier
                    .size(10.dp)
                    .background(
                        color = if (number == 2) Green else Color.Gray,
                        shape = CircleShape
                    ))
                Spacer(modifier = Modifier.width(5.dp))
                Box(modifier = Modifier
                    .size(10.dp)
                    .background(
                        color = if (number == 3) Green else Color.Gray,
                        shape = CircleShape
                    ))
            }
        }

        ButtonNext(
            modifier = Modifier
                .padding(bottom = 50.dp),
            onClick = onNext
        )
    }
}

@Composable
@Preview(showBackground = true)
fun IntroPreview() {
    Intro(title = "Hello", text = "Text world hello", number = 1, onNext = {})
}