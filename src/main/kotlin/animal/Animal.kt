package main.animal

import kotlinx.serialization.Serializable
import main.food.FeedingSchedule
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Serializable
abstract class Animal (
    val name: String = "",
    val species: Species,
    val dateOfBirth: String = "",
    val feedingSchedule: FeedingSchedule = species.defaultFeedingSchedule
) {
    override fun toString(): String {
        return "Name: $name, Species:  ${species.toString()}"
    }
    // todays date in string format d.m.YYYY
    val today: String = LocalDate.now().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
}
