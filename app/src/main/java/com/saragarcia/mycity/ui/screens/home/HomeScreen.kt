package com.saragarcia.mycity.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.saragarcia.mycity.R
import com.saragarcia.mycity.model.Location
import com.saragarcia.mycity.utils.ContentType
import com.saragarcia.mycity.utils.NavigationType
import kotlinx.coroutines.CoroutineScope

@Composable
fun HomeScreen(
    navController: NavHostController,
    windowSizeClass: WindowWidthSizeClass,
    scope: CoroutineScope,
    navigationType: NavigationType,
    contentType: ContentType,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues = PaddingValues(0.dp),
) {

    val viewModel: HomeScreenViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    HomeScreenContent(
        contentType = contentType,
        viewModel = viewModel,
        uiState = uiState,
        onBackPressed = onBackPressed,
        innerPadding = innerPadding,
        modifier = modifier
    )
}

@Composable
private fun HomeScreenContent(
    contentType: ContentType,
    viewModel: HomeScreenViewModel,
    uiState: HomeScreenUiState,
    onBackPressed: () -> Unit,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    if (contentType == ContentType.ListAndDetail) {
        RecommendationsListAndDetail(
            selectedLocation = uiState.currentLocation,
            locations = uiState.locations,
            onClick = { viewModel.updateCurrentRecommendation(it) },
            onBackPressed = onBackPressed,
            contentPadding = innerPadding,
            modifier = modifier.fillMaxWidth()
        )
    } else {
        if (uiState.isShowingListPage) {
            RecommendationsList(
                locations = uiState.locations,
                onClick = {
                    viewModel.updateCurrentRecommendation(it)
                    viewModel.navigateToDetailPage()
                },
                contentPadding = innerPadding,
                modifier = modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_medium)),
            )
        } else {
            RecommendationsDetail(
                selectedLocation = uiState.currentLocation,
                onBackPressed = {
                    viewModel.navigateToListPage()
                },
                contentPadding = innerPadding,
                modifier = modifier
            )
        }
    }
}


@Composable
private fun RecommendationsListAndDetail(
    locations: List<Location>,
    selectedLocation: Location,
    onClick: (Location) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Row(modifier = modifier) {
        RecommendationsList(
            locations = locations,
            onClick = onClick,
            contentPadding = PaddingValues(top = contentPadding.calculateTopPadding()),
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
        )
        RecommendationsDetail(
            selectedLocation = selectedLocation,
            modifier = Modifier.weight(3f),
            contentPadding = PaddingValues(top = contentPadding.calculateTopPadding(),),
            onBackPressed = onBackPressed,
        )
    }
}

@Preview (showBackground = true)
@Composable
fun HomeScreenCompactPreview() {
    HomeScreen(
        navController = rememberNavController(),
        windowSizeClass = WindowWidthSizeClass.Compact,
        navigationType = NavigationType.BOTTOM_NAVIGATION,
        contentType = ContentType.ListOnly,
        scope = rememberCoroutineScope(),
        onBackPressed = {}
    )
}

@Preview (showBackground = true)
@Composable
fun HomeScreenMediumPreview() {
    HomeScreen(
        navController = rememberNavController(),
        windowSizeClass = WindowWidthSizeClass.Medium,
        navigationType = NavigationType.BOTTOM_NAVIGATION,
        contentType = ContentType.ListOnly,
        scope = rememberCoroutineScope(),
        onBackPressed = {}
    )
}

@Preview (showBackground = true)
@Composable
fun HomeScreenExpandedPreview() {
    HomeScreen(
        navController = rememberNavController(),
        windowSizeClass = WindowWidthSizeClass.Expanded,
        navigationType = NavigationType.BOTTOM_NAVIGATION,
        contentType = ContentType.ListOnly,
        scope = rememberCoroutineScope(),
        onBackPressed = {}
    )
}