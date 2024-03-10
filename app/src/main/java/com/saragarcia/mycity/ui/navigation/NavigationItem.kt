package com.saragarcia.mycity.ui.navigation

data class NavigationItem(
    val destination: Destination,
    val onSelect: () -> Unit
)