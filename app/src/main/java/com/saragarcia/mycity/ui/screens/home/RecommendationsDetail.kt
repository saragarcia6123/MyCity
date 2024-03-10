package com.saragarcia.mycity.ui.screens.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saragarcia.mycity.data.RecommendationsProvider
import com.saragarcia.mycity.model.Location

@Composable
fun RecommendationsDetail(
    selectedLocation: Location,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    BackHandler {
        onBackPressed()
    }
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp)
            .fillMaxHeight()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = selectedLocation.title).uppercase(),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Image(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .clip(RoundedCornerShape(4.dp)),
                painter = painterResource(id = selectedLocation.image),
                contentDescription = null
            )
            Text(
                text = stringResource(id = selectedLocation.description),
                style = MaterialTheme.typography.bodyLarge
            )
            Box(modifier = Modifier.height(24.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RecommendationsDetailPreview() {
    RecommendationsDetail(selectedLocation = RecommendationsProvider.defaultRecommendation, onBackPressed = {})
}