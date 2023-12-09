package main.animal

import main.food.FeedingSchedule
import main.food.Food
import kotlinx.serialization.Serializable

@Serializable
data class Species(
    val genusName: String,
    val speciesName: String,
    val defaultAcceptedFood: Food,
    val defaultRequiredAmountPerDay: Int = 1,
    val defaultFeedingSchedule: FeedingSchedule
) {
    override fun toString(): String {
        return "$genusName $speciesName"
    }
}