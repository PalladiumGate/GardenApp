package com.csm.gardenapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csm.gardenapp.R
import com.csm.gardenapp.ui.theme.Green

@Composable
fun StyledButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Green
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

@Composable
fun ButtonNext(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    StyledButton(modifier = modifier, onClick = onClick) {
        Text(
            text = stringResource(id = R.string.next),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = rememberVectorPainter(image = Icons.Outlined.ArrowForward),
            contentDescription = "Next",
            colorFilter = ColorFilter.tint(color = Color.White)
        )
    }
}