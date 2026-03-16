package com.akcay.cinepass.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akcay.cinepass.theming.TextColors
import cinepass.composeapp.generated.resources.Res
import cinepass.composeapp.generated.resources.ic_eye_close
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun JWTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
) {
    var isFocused by remember { mutableStateOf(false) }
    val isLabelMinimized = value.isNotEmpty() || isFocused

    val labelFontSize by animateFloatAsState(targetValue = if (isLabelMinimized) 12f else 16f)

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            },
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                fontSize = labelFontSize.sp,
                style = MaterialTheme.typography.bodySmall.copy(color = TextColors.Label),
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = Color.White,
        ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextColors.Background,
            unfocusedContainerColor = TextColors.Background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(12.dp)
    )
}

@Composable
fun JWPasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }

    val isLabelMinimized = value.isNotEmpty() || isFocused
    val labelFontSize by animateFloatAsState(targetValue = if (isLabelMinimized) 12f else 16f)

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            },
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                fontSize = labelFontSize.sp,
                style = MaterialTheme.typography.bodySmall.copy(color = TextColors.Label),
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = Color.White,
        ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextColors.Background,
            unfocusedContainerColor = TextColors.Background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(12.dp),
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    painter = painterResource(if (isPasswordVisible) Res.drawable.ic_eye_close else Res.drawable.ic_eye_close),
                    contentDescription = "Toggle password visibility"
                )
            }
        }
    )
}

@Composable
@Preview
fun JWTextFieldPreview(modifier: Modifier = Modifier) {
    JWTextField(
        modifier = modifier.padding(10.dp),
        value = "",
        label = "Test Label",
        onValueChange = {}
    )
}

@Composable
@Preview
fun JWPasswordTextFieldPreview(modifier: Modifier = Modifier) {
    JWPasswordTextField(
        modifier = modifier.padding(10.dp),
        value = "val",
        label = "Test Label",
        onValueChange = {}
    )
}