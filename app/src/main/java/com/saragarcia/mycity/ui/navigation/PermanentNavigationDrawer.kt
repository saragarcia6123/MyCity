package com.saragarcia.mycity.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.saragarcia.mycity.R

@Composable
fun PermanentNavDrawer(
    currentDestination: Destination,
    content: @Composable () -> Unit,
    navigationItemsList: List<NavigationItem>,
    modifier: Modifier = Modifier
) {
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {
                NavigationDrawerContent(
                    currentDestination = currentDestination,
                    onTabPressed = { /*TODO*/ },
                    navigationItemsList = navigationItemsList,
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.inverseOnSurface)
                        .padding(dimensionResource(R.dimen.drawer_padding_content))
                )
            }
        },
        content = content
    )
}

@Composable
fun NavigationDrawerContent(
    currentDestination: Destination,
    onTabPressed: () -> Unit,
    navigationItemsList: List<NavigationItem>,
    modifier: Modifier
) {

}