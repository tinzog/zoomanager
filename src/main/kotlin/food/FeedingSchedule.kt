package main.food

import kotlinx.serialization.Serializable

@Serializable
class FeedingSchedule(
    val feedingHours: List<Int> = listOf(8),
    val food: Food,
    val foodAmount: Int = 1,
    val foodUnit: String = "kg"
) {
    override fun toString(): String {
        return "FeedingSchedule: ${feedingHours.size} time(s) a day"
    }
}