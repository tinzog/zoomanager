package main.animal

import main.food.FeedingSchedule
import main.food.Food

data class Species(
    var genusName: String,
    var speciesName: String,
    var defaultFeedingSchedule: FeedingSchedule
) {
    val name = "$genusName $speciesName"
    override fun toString(): String {
        return "$genusName $speciesName"
    }
    public fun getDefaultFood(): Food {
        return defaultFeedingSchedule.food
    }
}