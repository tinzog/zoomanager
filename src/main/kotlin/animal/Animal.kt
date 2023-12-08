package main.animal

import java.time.LocalDate
import main.food.Food
import main.food.FeedingSchedule
import main.animal.Species


abstract class Animal(
    val name: String = "",
    val dateOfBirth: LocalDate,
    val species: Species,
    val acceptedFood: List<Food> = species.defaultAcceptedFood,
    val requiredAmountPerDay: Int = species.defaultRequiredAmountPerDay,
    val foodUnit: String,
    val feedingSchedule: FeedingSchedule
)
