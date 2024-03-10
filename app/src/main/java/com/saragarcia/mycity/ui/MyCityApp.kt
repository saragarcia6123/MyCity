package com.saragarcia.mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saragarcia.mycity.ui.navigation.BottomNavigationBarScreen
import com.saragarcia.mycity.ui.navigation.NavigationRailScreen
import com.saragarcia.mycity.ui.navigation.PermanentNavigationDrawerScreen
import com.saragarcia.mycity.utils.ContentType
import com.saragarcia.mycity.utils.NavigationType

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit,
) {

    val navigationType: NavigationType
    val contentType: ContentType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = NavigationType.BOTTOM_NAVIGATION
            contentType = ContentType.ListOnly
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = NavigationType.NAVIGATION_RAIL
            contentType = ContentType.ListOnly
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = NavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = ContentType.ListAndDetail
        }
        else -> {
            navigationType = NavigationType.BOTTOM_NAVIGATION
            contentType = ContentType.ListOnly
        }
    }

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val scope = rememberCoroutineScope()

    when (navigationType) {
        NavigationType.BOTTOM_NAVIGATION -> BottomNavigationBarScreen (
            navController = navController,
            scope = scope,
            contentType = contentType,
            navigationType = navigationType,
            navBackStackEntry = navBackStackEntry,
            windowWidthSizeClass = windowSize,
            onBackPressed = onBackPressed
        )
        NavigationType.NAVIGATION_RAIL -> NavigationRailScreen (
            navController = navController,
            scope = scope,
            contentType = contentType,
            navigationType = navigationType,
            navBackStackEntry = navBackStackEntry,
            windowWidthSizeClass = windowSize,
            onBackPressed = onBackPressed
        )
        NavigationType.PERMANENT_NAVIGATION_DRAWER -> PermanentNavigationDrawerScreen (
            navController = navController,
            scope = scope,
            contentType = contentType,
            navigationType = navigationType,
            navBackStackEntry = navBackStackEntry,
            windowWidthSizeClass = windowSize,
            onBackPressed = onBackPressed
        )
    }

}