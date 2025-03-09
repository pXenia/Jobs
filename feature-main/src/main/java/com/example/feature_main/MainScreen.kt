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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import com.example.core_network.model.Button
import com.example.core_ui.JobCard
import com.example.core_ui.RecommendationCard
import com.example.core_ui.Search
import com.example.core_ui.tools.Dimens
import com.example.core_ui.tools.getVacanciesText


@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
    onClick: () -> Unit
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            viewModel.compareWithDatabase()
        }
    }

    val vacancies by viewModel.vacancies.collectAsState()
    val offers by viewModel.offers.collectAsState()

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.padding16dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16dp)
        ) {

            // строка поиска и настройки
            Search(
                iconSettings = com.example.core_ui.R.drawable.ic_filter_default,
                iconSearch = com.example.core_ui.R.drawable.ic_search_default,
                onClick = {}
            )

            // рекомендации
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dimens.padding8dp)
            ) {
                itemsIndexed(items = offers) { index, offer ->
                    RecommendationCard(
                        id = index,
                        title = offer.title,
                        link = offer.link,
                        buttonText = offer.button?.text
                    )
                }
            }

            Spacer(modifier = Modifier.height(Dimens.padding16dp))

            // вакансии для вас
            Text(
                text = stringResource(R.string.vacancies_for_you),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleMedium
            )

            // 3 вакансии
            Column(
                verticalArrangement = Arrangement.spacedBy(Dimens.padding16dp)
            ) {
                vacancies.take(3).forEach { vacancy ->
                    JobCard(
                        modifier = Modifier,
                        numberViewers = vacancy.lookingNumber,
                        jobTitle = vacancy.title,
                        salary = vacancy.salary?.full,
                        city = vacancy.address.town,
                        company = vacancy.company,
                        experience = vacancy.experience.previewText,
                        datePublication = vacancy.publishedDate,
                        isFavourite = vacancy.isFavorite,
                        onClickFavourite = { viewModel.changeFavorites(vacancy) },
                        onCardClick = {}
                    )
                }
            }

            LoadMoreButton(
                amount = if (vacancies.size > 0) vacancies.size - 3 else vacancies.size,
                onClick = onClick
            )
        }
    }
}


@Composable
fun LoadMoreButton(
    amount: Int, onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(Dimens.cornerRadius8dp),
        colors = ButtonDefaults.buttonColors(
            MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Text(
            text = "Ещё ${getVacanciesText(amount)}",
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.labelLarge
        )
    }
}