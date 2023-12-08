package main.food

class FeedingSchedule(val feedingHours: List<Int>) {
    override fun toString(): String {
        return "FeedingSchedule: ${feedingHours.size} times a day"
    }
}