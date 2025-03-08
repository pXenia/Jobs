package com.example.core_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Search(
    iconSearch: Int,
    iconSettings: Int,
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SearchBar(
            modifier = Modifier
                .size(48.dp)
                .weight(1f),
            icon = iconSearch
        )
        FloatingButton(
            modifier = Modifier.size(48.dp),
            icon = iconSettings
        ) {
            // нажантие на фильтп
        }

    }
}