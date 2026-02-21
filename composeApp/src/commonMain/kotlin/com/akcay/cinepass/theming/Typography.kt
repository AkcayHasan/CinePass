package com.akcay.cinepass.theming

import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import justwatchmultiplatform.composeapp.generated.resources.Montserrat_Bold
import justwatchmultiplatform.composeapp.generated.resources.Montserrat_Medium
import justwatchmultiplatform.composeapp.generated.resources.Montserrat_Regular
import justwatchmultiplatform.composeapp.generated.resources.Montserrat_SemiBold
import justwatchmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

val Montserrat @Composable get() = FontFamily(
    Font(
        resource = Res.font.Montserrat_Regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resource = Res.font.Montserrat_Medium,
        weight = FontWeight.Medium,
    ),
    Font(
        resource = Res.font.Montserrat_SemiBold,
        weight = FontWeight.SemiBold,
    ),
    Font(
        resource = Res.font.Montserrat_Bold,
        weight = FontWeight.Bold,
    )
)

val Typography: Typography @Composable get() = Typography(
    bodyMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
    ),
)