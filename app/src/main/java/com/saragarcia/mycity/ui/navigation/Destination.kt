package com.saragarcia.mycity.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.saragarcia.mycity.R

sealed class Destination(val route: String) {
    data object Home : Destination("home")
    data object Map : Destination("map")

    data class LocationDetail(val locationId: String) : Destination("locationDetail/$locationId") {
        companion object {
            fun createRoute(locationId: String) = "locationDetail/$locationId"
        }
    }
}

