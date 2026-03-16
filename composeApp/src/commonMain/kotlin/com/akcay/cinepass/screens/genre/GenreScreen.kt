package com.akcay.cinepass.screens.genre

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.akcay.cinepass.components.JWPrimaryButton
import com.akcay.cinepass.theming.Brand
import com.akcay.cinepass.theming.JWTheme
import com.akcay.cinepass.theming.TextColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun GenreScreen(
    modifier: Modifier = Modifier,
) {
    GenreScreenContent(modifier = modifier)
}

@Composable
fun GenreScreenContent(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    text = "Skip",
                    style = MaterialTheme.typography.bodyMedium.copy(color = TextColors.Label),
                    textAlign = TextAlign.End,
                )
                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                    text = "Choose Your Favorite Genres",
                    style = MaterialTheme.typography.bodyLarge.copy(color = TextColors.Accent),
                    textAlign = TextAlign.Center,
                )
                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                    text = "Pick a few so we can personalize your experience.",
                    style = MaterialTheme.typography.bodyLarge.copy(color = TextColors.Primary),
                    textAlign = TextAlign.Center,
                )
                FlowRow(
                    modifier = Modifier.fillMaxWidth().padding(top = 32.dp),
                    horizontalArrangement = Arrangement.spacedBy(22.dp),
                    verticalArrangement = Arrangement.spacedBy(22.dp),
                ) {
                    genreList.forEach { genre ->
                        GenreItem(
                            title = genre.title,
                            icon = genre.icon,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = TextColors.Label,
            )
            JWPrimaryButton(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp).height(52.dp),
                text = "Continue",
                onClick = {},
            )
        }
    }
}

@Composable
private fun GenreItem(
    modifier: Modifier = Modifier,
    title: String = "",
    icon: String = "",
) {
    var isSelected by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .background(
                color = if (isSelected) TextColors.Accent else TextColors.Background,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable {
                isSelected = !isSelected
            }
            .padding(horizontal = 22.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            text = icon,
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = if (isSelected) Brand.Background else TextColors.Primary
            ),
        )
    }
}

@Composable
@Preview
fun GenreItemPreview(
    modifier: Modifier = Modifier,
) {
    JWTheme {
        GenreItem(
            modifier = modifier.padding(20.dp),
            title = "Horror",
            icon = "🎃",
        )
    }
}

@Composable
@Preview
fun GenreScreenPreview(
    modifier: Modifier = Modifier,
) {
    JWTheme {
        GenreScreenContent()
    }
}