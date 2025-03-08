package com.example.core_ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun FloatingButton(
    modifier: Modifier,
    icon: Int,
    onClick: () -> Unit,
){
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "",
        )
    }
}