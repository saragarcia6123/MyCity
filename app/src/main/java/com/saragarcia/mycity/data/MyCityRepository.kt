package com.saragarcia.mycity.data

import com.saragarcia.mycity.R
import com.saragarcia.mycity.model.Location

object RecommendationsProvider {
    val defaultRecommendation = getLocations()[0]


    fun getLocations(): List<Location> {

        return listOf(
            Location(
                id = 1,
                title = R.string.title_1,
                description = R.string.description_1,
                image = R.drawable.image_1
            ),
            Location(
                id = 2,
                title = R.string.title_2,
                description = R.string.description_2,
                image = R.drawable.image_2
            ),
            Location(
                id = 3,
                title = R.string.title_3,
                description = R.string.description_3,
                image = R.drawable.image_3
            )
        )
    }

}
