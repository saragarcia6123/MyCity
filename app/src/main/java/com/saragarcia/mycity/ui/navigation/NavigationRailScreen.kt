package com.saragarcia.mycity.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.saragarcia.mycity.utils.ContentType
import com.saragarcia.mycity.utils.NavigationType
import kotlinx.coroutines.CoroutineScope

class NavigationRailScreen(
    override val navController: NavHostController,
    override val navigationType: NavigationType,
    override val contentType: ContentType,
    override val navBackStackEntry: NavBackStackEntry?,
    override val scope: CoroutineScope,
    override val modifier: Modifier = Modifier,
    override val windowWidthSizeClass: WindowWidthSizeClass,
    override val onBackPressed: () -> Unit
) : NavigationScreen {

    @Composable
    fun NavRailScreen(
        navController: NavHostController,
        navigationType: NavigationType,
        contentType: ContentType,
        navBackStackEntry: NavBackStackEntry,
        scope: CoroutineScope,
        modifier: Modifier = Modifier
    ) {
        Scaffold(

        ) { innerPadding ->
            Content(
                innerPadding = innerPadding,
                modifier = modifier
            )
        }
    }

    @Composable
    override fun Content(
        innerPadding: PaddingValues,
        modifier: Modifier
    ) {
        TODO("Not yet implemented")
    }

}