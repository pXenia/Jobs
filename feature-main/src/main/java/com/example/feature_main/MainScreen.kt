package com.example.feature_main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_ui.JobCard
import com.example.core_ui.RecommendationCard
import com.example.core_ui.Search


@Preview(showSystemUi = true)
@Composable
fun MainScreen(viewModel: MainScreenViewModel = hiltViewModel()
) {
    val vacancies by viewModel.vacancies.collectAsState()

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Search(
                iconSettings = com.example.core_ui.R.drawable.ic_filter_default,
                iconSearch = com.example.core_ui.R.drawable.ic_search_default
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(3) {
                    RecommendationCard(
                        title = "ffkfkf",
                        icon = com.example.core_ui.R.drawable.ic_location_default
                    ) { }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Вакансии для вас",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleMedium
            )

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = vacancies, key = { it.id }) { vacancy ->
                    JobCard(
                        modifier = Modifier,
                        numberViewers = vacancy.lookingNumber,
                        jobTitle = vacancy.title,
                        city = vacancy.address.town,
                        company = vacancy.company,
                        experience = vacancy.experience.previewText,
                        datePublication = vacancy.publishedDate,
                        isFavourite = vacancy.isFavorite
                    )
                }
            }

            LoadMoreButton()

        }
    }
}


@Composable
fun LoadMoreButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Text(text = "Еще 143 вакансии", color = MaterialTheme.colorScheme.onPrimary)
    }
}