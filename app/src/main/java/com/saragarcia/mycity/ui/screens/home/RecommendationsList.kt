package com.saragarcia.mycity.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saragarcia.mycity.R
import com.saragarcia.mycity.data.RecommendationsProvider
import com.saragarcia.mycity.model.Location

@Composable
fun RecommendationListItem(location: Location, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(text = stringResource(id = location.title))
    }
}

@Composable
fun RecommendationsList(
    locations: List<Location>,
    onClick: (Location) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
            .padding(top = dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(locations, key = { recommendation -> recommendation.id }) { recommendation ->
            RecommendationListItem(recommendation)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationsListPreview() {
    RecommendationsList(locations = RecommendationsProvider.getLocations(), onClick = {} )
}