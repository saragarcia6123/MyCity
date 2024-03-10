package com.saragarcia.mycity.ui.screens.home

import androidx.lifecycle.ViewModel
import com.saragarcia.mycity.data.RecommendationsProvider
import com.saragarcia.mycity.model.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState

    init {
        loadRecommendations()
    }

    //Can update in the future to load from API or database
    private fun loadRecommendations() {
        _uiState.value = HomeScreenUiState(
            isLoading = false,
            isShowingListPage = false,
            locations = RecommendationsProvider.getLocations(),
            currentLocation = RecommendationsProvider.defaultRecommendation
        )
    }

    fun updateCurrentRecommendation(selectedLocation: Location) {
        _uiState.update {
            it.copy(currentLocation = selectedLocation)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }


    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }

}

data class HomeScreenUiState (
    val isLoading: Boolean = true,
    val isShowingListPage: Boolean = false,
    val locations: List<Location> = listOf(),
    val currentLocation: Location = RecommendationsProvider.defaultRecommendation
)