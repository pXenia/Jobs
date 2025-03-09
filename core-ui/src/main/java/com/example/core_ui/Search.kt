package com.example.core_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_ui.tools.Dimens

@Composable
fun Search(
    iconSearch: Int,
    iconSettings: Int,
    onClick: () -> Unit
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(Dimens.padding8dp)
    ) {
        SearchBar(
            modifier = Modifier
                .size(48.dp)
                .weight(1f),
            icon = iconSearch,
            onClick = onClick
        )
        FloatingButton(
            modifier = Modifier.size(48.dp),
            icon = iconSettings
        ) {
            // нажантие на фильтр
        }

    }
}