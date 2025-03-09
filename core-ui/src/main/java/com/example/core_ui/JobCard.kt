package com.example.core_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun JobCard(
    modifier: Modifier = Modifier,
    numberViewers: String,
    jobTitle: String,
    cities: List<String>,
    experience: String,
    datePublication: String,
    isFavourite: Boolean,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                JobInfo(numberViewers, jobTitle, cities, experience, datePublication)
                Icon(
                    painter = if (isFavourite) painterResource(id = R.drawable.ic_heart_active)
                    else painterResource(
                        id = R.drawable.ic_heart_default
                    ),
                    contentDescription = "",
                )
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                contentPadding = PaddingValues(7.dp)
            ) {
                Text(
                    text = "Откликнуться",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
private fun JobInfo(
    numberViewers: String,
    jobTitle: String,
    cities: List<String>,
    experience: String,
    datePublication: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = numberViewers,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = jobTitle,
            style = MaterialTheme.typography.titleSmall
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            cities.forEach { city ->
                Text(
                    text = city,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "",
            )
            Text(
                text = experience,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Text(
            text = datePublication,
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun JobCardPreview() {
    JobCard(
        modifier = Modifier,
        numberViewers = "Сейчас просматривает 1 человек",
        jobTitle = "UI/UX Designer",
        cities = listOf("Минск", "Мобирикс"),
        experience = "Опыт от 1 года до 3 лет",
        datePublication = "Опубликовано 20 февраля",
        isFavourite = true
    )
}


