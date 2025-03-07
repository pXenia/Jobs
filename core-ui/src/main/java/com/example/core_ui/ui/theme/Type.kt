package com.example.core_ui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core_ui.R

val SFProDisplay = FontFamily(
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal)
)


val AppTypography = Typography(
    titleLarge = TextStyle( // Title 1
        fontFamily = SFProDisplay,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold
    ),
    titleMedium = TextStyle( // Title 2
        fontFamily = SFProDisplay,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    ),
    titleSmall = TextStyle( // Title 3
        fontFamily = SFProDisplay,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    bodyLarge = TextStyle( // Title 4
        fontFamily = SFProDisplay,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    bodyMedium = TextStyle( // Text 1
        fontFamily = SFProDisplay,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle( // Button text 1
        fontFamily = SFProDisplay,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    ),
    labelMedium = TextStyle( // Button text 2
        fontFamily = SFProDisplay,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    labelSmall = TextStyle( // Tab text
        fontFamily = SFProDisplay,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal
    ),
    displaySmall = TextStyle( // Number
        fontFamily = SFProDisplay,
        fontSize = 7.sp,
        fontWeight = FontWeight.Normal
    )
)
