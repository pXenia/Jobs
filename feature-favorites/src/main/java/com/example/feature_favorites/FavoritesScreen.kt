package com.example.feature_favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core_ui.BottomNavigationBar
import com.example.core_ui.FloatingButton
import com.example.core_ui.JobCard
import com.example.core_ui.R
import com.example.core_ui.RecommendationCard
import com.example.core_ui.Search
import com.example.core_ui.SearchBar


@Composable
fun FavoritesScreen() {
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
                iconSettings = R.drawable.ic_filter_default,
                iconSearch = R.drawable.ic_search_default
            )

            FavoritesSort()

            Spacer(modifier = Modifier.height(9.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(3) { vacancy ->
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
            }
        }
    }
}

@Composable
private fun FavoritesSort(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = "145 dfrfycbq",
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = " dfrfycbq",
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.bodyMedium
        )

        Icon(
            painter = painterResource(R.drawable.ic_sort_default),
            contentDescription = "",
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}
