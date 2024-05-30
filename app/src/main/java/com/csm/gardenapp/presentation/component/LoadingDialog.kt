package com.csm.gardenapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

// Для того, чтобы показывать диалог загрузки, используется MaterialLoadingDialog
@Composable
fun MaterialLoadingDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit = {}
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(150.dp)
                    .padding(16.dp)
                    .background(color = Color.Gray, shape = RoundedCornerShape(17.dp))
                    .padding(10.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(150.dp)
                        .padding(16.dp)
                )
            }
        }
    }
}
