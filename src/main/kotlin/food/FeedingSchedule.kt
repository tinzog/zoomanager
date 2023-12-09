package main.food

import kotlinx.serialization.Serializable

@Serializable
public class FeedingSchedule(
    var feedingHours: List<Int> = listOf(8),
    var food: Food,
    var foodAmount: Int = 1,
    var foodUnit: String = food.foodUnit.toString()
) {

    override fun toString(): String {
        return "FeedingSchedule: ${feedingHours.size} time(s) a day"
    }
}