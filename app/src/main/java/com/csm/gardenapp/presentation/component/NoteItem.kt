package com.csm.gardenapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csm.gardenapp.domain.model.Note
import com.csm.gardenapp.ui.theme.Grey

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note: Note,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .background(color = Grey, RoundedCornerShape(15.dp))
            .padding(10.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = note.name,
                fontSize = 23.sp
            )
            Text(
                text = note.dateCreated,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 5.dp)
            )
        }

        Image(
            painter = rememberVectorPainter(image = Icons.AutoMirrored.Filled.KeyboardArrowRight),
            contentDescription = "Open note icon",
            modifier = Modifier.size(40.dp)
        )
    }
}