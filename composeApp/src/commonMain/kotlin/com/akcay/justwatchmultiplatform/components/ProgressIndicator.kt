package com.akcay.justwatchmultiplatform.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.akcay.justwatchmultiplatform.theming.JWTheme
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ProgressIndicator(visible: Boolean, modifier: Modifier = Modifier) {
    if (visible) {
        Dialog(onDismissRequest = {}) {
            ProgressAnimation()
        }
    }
}

@Composable
fun ProgressAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 10.dp,
    circleColor: Color = Color.Magenta,
    spaceBetween: Dp = 5.dp,
    distance: Dp = 10.dp,
) {
    val circles = listOf(
        remember { Animatable(0f) },
        remember { Animatable(0f) },
        remember { Animatable(0f) },
    )
    val circleValues = circles.map { it.value }
    val distance = with(LocalDensity.current) { distance.toPx() }

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        0f at 0
                        1f at 300
                        0f at 600
                        0f at 1200 using LinearEasing
                    },
                    repeatMode = RepeatMode.Restart,
                ),
            )
        }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween),
    ) {
        circleValues.forEach { value ->
            Box(
                modifier = Modifier
                    .size(circleSize)
                    .graphicsLayer {
                        translationY = -value * distance
                    }
                    .background(circleColor, CircleShape),
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProgressAnimationPreview(modifier: Modifier = Modifier) {
    JWTheme {
        ProgressAnimation(modifier.padding(20.dp))
    }
}
