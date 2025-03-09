package com.example.core_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core_ui.tools.Dimens


@Composable
fun BottomNavigationBar(
    selectedItem: Int,
    showBadge: Boolean = false,
    numberFavourites: Int = 1,
    onItemSelected: (Int) -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(Dimens.padding6dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf(
                R.drawable.ic_search_default to "Поиск",
                R.drawable.ic_heart_default to "Избранное",
                R.drawable.ic_responses_default to "Отклики",
                R.drawable.ic_message_default to "Сообщения",
                R.drawable.ic_user_default to "Профиль"
            ).forEachIndexed { index, (icon, label) ->
                BottomNavItem(
                    iconId = icon,
                    label = label,
                    isSelected = selectedItem == index,
                    showBadge = showBadge && index == 1,
                    numberFavourites = numberFavourites
                ) { onItemSelected(index) }
            }
        }
        Spacer(modifier = Modifier.height(Dimens.padding16dp))
    }
}



@Composable
fun BottomNavItem(
    iconId: Int,
    label: String,
    isSelected: Boolean,
    showBadge: Boolean = false,
    numberFavourites: Int = 1,
    onClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .padding(bottom = Dimens.padding4dp)
            .clickable { onClick() }
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = label,
                tint = if (isSelected) {
                    MaterialTheme.colorScheme.onSecondaryContainer
                } else MaterialTheme.colorScheme.outline,
            )
            if (showBadge) {
                Box(
                    modifier = Modifier
                        .padding(top = Dimens.padding2dp, start = Dimens.padding16dp)
                        .size(13.dp)
                        .background(MaterialTheme.colorScheme.error, shape = CircleShape)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = numberFavourites.toString(),
                        style = MaterialTheme.typography.displaySmall,
                    )
                }
            }
        }
        Text(
            text = label,
            color = if (isSelected) {
                MaterialTheme.colorScheme.onSecondaryContainer
            } else MaterialTheme.colorScheme.outline,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

