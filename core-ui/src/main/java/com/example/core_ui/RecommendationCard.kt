package com.example.core_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core_ui.tools.Dimens

@Composable
fun RecommendationCard(
    id: Int,
    title: String,
    link: String,
    buttonText: String?
) {
    val uriHandler = LocalUriHandler.current
    val recommendationIcons = listOf(
        RecommendationIconData(
            R.drawable.ic_location_default,
            MaterialTheme.colorScheme.onSecondaryContainer,
            MaterialTheme.colorScheme.primary
        ),
        RecommendationIconData(
            R.drawable.ic_star_default,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.tertiary
        ),
        RecommendationIconData(
            R.drawable.ic_vacancy_default,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.tertiary
        )
    )

    Card(
        modifier = Modifier
            .width(132.dp)
            .height(148.dp)
            .clickable {
                uriHandler.openUri(link) // Открытие ссылки
            },
        shape = RoundedCornerShape(Dimens.cornerRadius8dp),
    ) {
        Column(
            modifier = Modifier.padding(Dimens.padding8dp),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding8dp),
        ) {
            // отображаемая иконка
            if (id in listOf(0, 1, 2)) {
                RecommendationIcon(
                    icon = recommendationIcons[id].icon,
                    colorIcon = recommendationIcons[id].colorIcon,
                    colorBackground = recommendationIcons[id].colorBackground
                )
            }
            else
                Spacer(modifier = Modifier.height(Dimens.padding48dp))

            // текст рекомендации
            Text(
                text = title.trim(),
                style = MaterialTheme.typography.bodyLarge,
                maxLines = if (buttonText != null) 2 else 3,
                overflow = TextOverflow.Ellipsis
            )

            // текст кнопки (если есть)
            if (buttonText != null) {
                Text(
                    text = buttonText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF4CAF50) // Зеленый цвет
                )
            }
        }
    }
}

private data class RecommendationIconData(
    val icon: Int,
    val colorIcon: Color,
    val colorBackground: Color
)

@Composable
private fun RecommendationIcon(
    icon: Int,
    colorIcon: Color,
    colorBackground: Color
) {
    IconButton(
        onClick = {},
        modifier = Modifier
            .background(
                color = colorBackground,
                shape = RoundedCornerShape(Dimens.cornerRadius32dp)
            )
    ) {
        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier
                .size(Dimens.iconSize24dp),
            contentDescription = null,
            tint = colorIcon
        )
    }
}
