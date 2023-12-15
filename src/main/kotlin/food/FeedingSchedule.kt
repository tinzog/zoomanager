package main.food

public class FeedingSchedule(
    var feedingTimes: Int = 1,
    var food: Food,
    var foodAmount: Int = 1,
    var foodUnit: String = food.foodUnit.toString()
) {
    override fun toString(): String {
        return "FeedingSchedule: ${feedingTimes} time(s) a day, Food: ${food.name}, Amount: ${foodAmount} ${foodUnit}
    }
}