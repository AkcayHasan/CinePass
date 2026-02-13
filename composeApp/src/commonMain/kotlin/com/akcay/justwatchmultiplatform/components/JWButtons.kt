package com.akcay.justwatchmultiplatform.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.akcay.justwatchmultiplatform.theming.Brand
import com.akcay.justwatchmultiplatform.theming.JWTheme
import com.akcay.justwatchmultiplatform.theming.TextColors
import justwatchmultiplatform.composeapp.generated.resources.Res
import justwatchmultiplatform.composeapp.generated.resources.ic_google
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun JWPrimaryButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = Brand.Button,
    modifier: Modifier = Modifier,
) {
    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
        )
    }
}

@Composable
fun JWSecondaryButton(
    text: String,
    onClick: () -> Unit,
    trailingIcon: DrawableResource? = null,
    modifier: Modifier = Modifier,
) {
    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Brand.Background),
        border = BorderStroke(1.dp, TextColors.Label),
    ) {
        trailingIcon?.let { icon ->
            Icon(
                modifier = Modifier.padding(end = 10.dp),
                painter = painterResource(icon),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
        )
    }
}

@Composable
fun JWTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier.clickable(
            onClick = onClick,
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
        ),
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(color = TextColors.Accent),
        textDecoration = TextDecoration.Underline,
    )
}

@Composable
@Preview
fun JWPrimaryButtonPreview(
    modifier: Modifier = Modifier,
) {
    JWTheme {
        JWPrimaryButton(
            modifier = modifier.height(68.dp).padding(10.dp),
            text = "Test Button",
            onClick = {},
        )
    }
}

@Composable
@Preview
fun JWSecondaryButtonPreview(
    modifier: Modifier = Modifier,
) {
    JWTheme {
        JWSecondaryButton(
            modifier = modifier.height(68.dp).padding(10.dp),
            text = "Continue with Google",
            onClick = {},
            trailingIcon = Res.drawable.ic_google,
        )
    }
}

@Composable
@Preview
fun JWTextButtonPreview(
    modifier: Modifier = Modifier,
) {
    JWTheme {
        JWTextButton(
            modifier = modifier.padding(10.dp),
            text = "Continue with Google",
            onClick = {},
        )
    }
}