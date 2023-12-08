package main.animal

import main.food.Food
import main.food.FeedingSchedule

class Species(
    val genusName: String,
    val speciesName: String,
    val defaultAcceptedFood: List<Food>,
    val defaultRequiredAmountPerDay: Int,
    val defaultFeedingSchedule: FeedingSchedule
) {
    override fun toString(): String {
        return "$genusName $speciesName"
    }
}