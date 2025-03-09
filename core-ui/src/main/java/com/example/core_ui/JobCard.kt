package com.example.core_ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.tools.Dimens
import com.example.core_ui.tools.getPeopleCountText
import com.example.core_ui.tools.getPublishedDateText

@Composable
fun JobCard(
    modifier: Modifier = Modifier,
    numberViewers: Int?,
    jobTitle: String,
    salary: String?,
    city: String,
    company: String,
    experience: String,
    datePublication: String,
    isFavourite: Boolean,
    onClickFavourite: () -> Unit,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier
            .clickable { onCardClick() },
        shape = RoundedCornerShape(Dimens.cornerRadius8dp)
    ) {
        Column(
            modifier = Modifier.padding(Dimens.padding16dp),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding10dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                JobInfo(
                    modifier = Modifier.weight(1f),
                    numberViewers,
                    jobTitle,
                    salary,
                    city,
                    company,
                    experience,
                    datePublication
                )
                FavouriteMark(isFavourite, onClickFavourite)
            }
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                contentPadding = PaddingValues(Dimens.padding7dp)
            ) {
                Text(
                    text = stringResource(R.string.respond),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun FavouriteMark(
    isFavourite: Boolean, onClickFavourite: () -> Unit
) {
    if (isFavourite) {
        Icon(
            painter = painterResource(id = R.drawable.ic_heart_active),
            contentDescription = "favourite",
            modifier = Modifier
                .size(Dimens.iconSize24dp)
                .clickable { onClickFavourite() },
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
    } else {
        Icon(
            painter = painterResource(id = R.drawable.ic_heart_default),
            contentDescription = "not favourite",
            modifier = Modifier
                .size(Dimens.iconSize24dp)
                .clickable { onClickFavourite() },
            tint = MaterialTheme.colorScheme.outline
        )
    }
}

@Composable
private fun JobInfo(
    modifier: Modifier,
    numberViewers: Int?,
    jobTitle: String,
    salary: String?,
    city: String,
    company: String,
    experience: String,
    datePublication: String
) {
    Column(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(Dimens.padding10dp)
    ) {
        // сколько просматривает
        if (numberViewers != null) Text(
            text = getPeopleCountText(numberViewers),
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyMedium
        )

        // название вакансии
        Text(
            text = jobTitle, style = MaterialTheme.typography.titleSmall
        )

        // зп
        if (salary != null && salary != stringResource(R.string.not_salary)) {
            Text(
                text = salary, style = MaterialTheme.typography.titleMedium
            )
        }

        // город и название вакансии
        CompanyAddress(city, company)

        // требуемый опыт
        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimens.padding8dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_experience_default),
                contentDescription = "experience",
                modifier = Modifier.size(Dimens.iconSize16dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = experience, style = MaterialTheme.typography.bodyMedium
            )
        }

        // дата публикации
        Text(
            text = getPublishedDateText(datePublication),
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun CompanyAddress(
    city: String,
    company: String,
) {
    Column {

        // город
        Text(
            text = city, style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(Dimens.padding4dp))

        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            // название компании
            Text(
                text = company, style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.width(Dimens.padding8dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_checkmark_default),
                contentDescription = "check",
                modifier = Modifier.size(Dimens.iconSize16dp),
                tint = MaterialTheme.colorScheme.inversePrimary
            )
        }
    }
}


