package com.csm.gardenapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.csm.gardenapp.R

// Кастомные текстовые поля

@Composable
fun StyledTextField(
    modifier: Modifier = Modifier,
    placeHolder: String,
    text: String,
    onValueChange: (String) -> Unit = {},
) {
    Column {
        OutlinedTextField(
            value = text,
            onValueChange = { onValueChange(it) },
            label = {
                Text(placeHolder)
            },
            modifier = modifier
        )
    }

}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    placeHolder: String,
    text: String,
    enabled : Boolean = true,
    onValueChange: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.visible_icon)
        else
            painterResource(id = R.drawable.invisible_icon)

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = {
                onValueChange(it)
            },
            label = { Text(text = placeHolder) },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            enabled = enabled,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = modifier,
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TextFieldPreview() {
    var text by remember { mutableStateOf("Hello") }
    StyledTextField(placeHolder = "Email", text = text, onValueChange = { text = it })
}

@Composable
@Preview(showBackground = true)
fun PasswordTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    PasswordTextField(placeHolder = "", text = text, onValueChange = { text = it })
}