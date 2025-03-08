package com.example.core_ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun FloatingButton(
    modifier: Modifier,
    onClick: () -> Unit,
){
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_filter_default),
            contentDescription = "",
        )
    }
}