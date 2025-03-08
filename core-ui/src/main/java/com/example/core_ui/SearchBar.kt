package com.example.core_ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(
    modifier: Modifier,
    isMoreInfo: Boolean // иконка поиска или стрелка назад
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        placeholder = {
            Text(
                text = stringResource(R.string.position_keywords),
                color = MaterialTheme.colorScheme.inversePrimary,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = {
            Icon(
                painter = if (isMoreInfo) painterResource(id = R.drawable.ic_arrow_default)
                else painterResource(
                    id = R.drawable.ic_search_default
                ),
                contentDescription = "",
            )
        },
        shape = RoundedCornerShape(8.dp)
    )
}