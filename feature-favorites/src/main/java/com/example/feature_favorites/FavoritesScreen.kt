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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core_ui.BottomNavigationBar
import com.example.core_ui.FloatingButton
import com.example.core_ui.JobCard
import com.example.core_ui.R
import com.example.core_ui.RecommendationCard
import com.example.core_ui.Search
import com.example.core_ui.SearchBar
import com.example.core_ui.tools.Dimens
import com.example.core_ui.tools.getVacanciesText


@Composable
fun FavoritesScreen(
        viewModel: FavoriteScreenViewModel = hiltViewModel(),
    ) {

    val vacancies by viewModel.favoriteVacancies.collectAsState()

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Spacer(modifier = Modifier.height(Dimens.padding64dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.padding16dp),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16dp)
        ) {

            Spacer(modifier = Modifier.height(Dimens.padding16dp))

            // избранное
            Text(
                text = stringResource(com.example.feature_favorites.R.string.favorite),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(Dimens.padding4dp))

            // кол-во вакансий
            Text(
                text = getVacanciesText(vacancies.size),
                color = MaterialTheme.colorScheme.inversePrimary,
                style = MaterialTheme.typography.labelMedium
            )

            // избранные вакансии
            LazyColumn(
                modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(Dimens.padding8dp)
            ) {
                items(items = vacancies, key = { it.id }) { vacancy ->
                    JobCard(modifier = Modifier,
                        numberViewers = vacancy.numberViewers,
                        jobTitle = vacancy.jobTitle,
                        salary = vacancy.salary,
                        city = vacancy.city,
                        company = vacancy.company,
                        experience = vacancy.experience,
                        datePublication = vacancy.datePublication,
                        isFavourite = vacancy.isFavourite,
                        onClickFavourite = { viewModel.changeFavorites(vacancy) },
                        onCardClick = {})
                }
            }
        }
    }
}