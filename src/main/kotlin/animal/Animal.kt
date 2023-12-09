package main.animal

import main.food.FeedingSchedule
import main.food.Food
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Serializable
abstract class Animal (
    val name: String = "",
    val dateOfBirth: String = "",
    val species: Species,
    val acceptedFood: Food = species.defaultAcceptedFood,
    val requiredAmountPerDay: Int = species.defaultRequiredAmountPerDay,
    val foodUnit: String,
    val feedingSchedule: FeedingSchedule
) {
    override fun toString(): String {
        return "Name: $name, Species:  ${species.toString()}"
    }
    // todays date in string format d.m.YYYY
    val today: String = LocalDate.now().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
}
