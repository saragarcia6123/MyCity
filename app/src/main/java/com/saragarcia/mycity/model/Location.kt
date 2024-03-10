package com.saragarcia.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Location (
    val id: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)