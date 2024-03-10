package com.saragarcia.mycity.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.saragarcia.mycity.utils.ContentType
import com.saragarcia.mycity.utils.NavigationType
import kotlinx.coroutines.CoroutineScope

interface NavigationScreen {

    val navController: NavHostController
    val windowWidthSizeClass: WindowWidthSizeClass
    val navigationType: NavigationType
    val contentType: ContentType
    val navBackStackEntry: NavBackStackEntry?
    val scope: CoroutineScope
    val onBackPressed: () -> Unit
    val modifier: Modifier

    @Composable
    fun Content(
        innerPadding: PaddingValues,
        modifier: Modifier
    ) {
        NavigationGraph(
            navController = navController,
            windowWidthSizeClass = windowWidthSizeClass,
            scope = scope,
            innerPadding = innerPadding,
            navigationType = navigationType,
            onBackPressed = onBackPressed,
            contentType = contentType
        )
    }

}
