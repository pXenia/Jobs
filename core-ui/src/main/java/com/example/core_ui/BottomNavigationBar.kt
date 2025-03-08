package com.example.core_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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


@Composable
fun BottomNavigationBar(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(
            iconId = R.drawable.ic_search_default,
            label = "Поиск",
            isSelected = selectedItem == 0
        ) { onItemSelected(0) }
        BottomNavItem(
            iconId = R.drawable.ic_heart_default,
            label = "Избранное",
            isSelected = selectedItem == 1,
            showBadge = true
        ) { onItemSelected(1) }
        BottomNavItem(
            iconId = R.drawable.ic_responses_default,
            label = "Отклики",
            isSelected = selectedItem == 2
        ) { onItemSelected(2) }
        BottomNavItem(
            iconId = R.drawable.ic_message_default,
            label = "Сообщения",
            isSelected = selectedItem == 3
        ) { onItemSelected(3) }
        BottomNavItem(
            iconId = R.drawable.ic_user_default,
            label = "Профиль",
            isSelected = selectedItem == 4
        ) { onItemSelected(4) }
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
            .padding(bottom = 3.dp)
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
                        .padding(top = 2.dp, start = 16.dp)
                        .size(13.dp)
                        .background(MaterialTheme.colorScheme.error, shape = CircleShape)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ){
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

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(1) {}
}
