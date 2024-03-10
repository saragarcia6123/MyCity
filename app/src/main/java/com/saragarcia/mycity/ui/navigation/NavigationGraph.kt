package com.saragarcia.mycity.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saragarcia.mycity.ui.screens.home.HomeScreen
import com.saragarcia.mycity.utils.ContentType
import com.saragarcia.mycity.utils.NavigationType
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavigationGraph(
    navController: NavHostController,
    windowWidthSizeClass: WindowWidthSizeClass,
    scope: CoroutineScope,
    innerPadding: PaddingValues,
    navigationType: NavigationType,
    onBackPressed: () -> Unit,
    contentType: ContentType,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(route = Destination.Home.route) {
            HomeScreen(
                navController = navController,
                windowSizeClass = windowWidthSizeClass,
                scope = scope,
                navigationType = navigationType,
                contentType = contentType,
                onBackPressed = onBackPressed,
                innerPadding = innerPadding,
                modifier = modifier
                    .fillMaxSize()
            )
        }
    }
}