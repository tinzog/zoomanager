package main.animal

import enclosure.Enclosure
import main.food.FeedingSchedule
import main.zoo.Zoo
import java.time.LocalDate

enum class Gender {
    MALE, FEMALE, UNKNOWN
}

enum class Sizegroup {
    SMALL, LARGE, UNKNOWN
}

abstract class Animal internal constructor(
    val name: String? = null,
    val species: Species,
    val dateOfBirth: LocalDate = LocalDate.now(),
    val gender: Gender = Gender.UNKNOWN,
    val weight: Int = 0,
    private var enclosure: Enclosure,
    var customFeedingSchedule: FeedingSchedule = species.defaultFeedingSchedule
) {
    // Secondary constructor
    constructor(
        speciesName: String,
        enclosureName: String,
        zoo: Zoo,
        name: String? = null,
        dateOfBirth: LocalDate = LocalDate.now(),
        gender: Gender = Gender.UNKNOWN,
        weight: Int = 0
    ) : this(
        name = name,
        species = zoo.getSpeciesByName(speciesName) ?: throw IllegalArgumentException("Species $speciesName does not exist. Please create the species first."),
        dateOfBirth = dateOfBirth,
        gender = gender,
        weight = weight,
        enclosure = zoo.getEnclosureByName(enclosureName) ?: throw IllegalArgumentException("Enclosure $enclosureName does not exist. Please create the enclosure first.")
    )
    fun setCustomFeedingSchedule(feedingSchedule: FeedingSchedule) {
        this.customFeedingSchedule = feedingSchedule
    }
    fun getAge(): Int {
        val today = LocalDate.now()
        return today.year - dateOfBirth.year - if (today.dayOfYear < dateOfBirth.dayOfYear) 1 else 0
    }

    val sizeGroup: Sizegroup
        get() = if (weight < 10) Sizegroup.SMALL else Sizegroup.LARGE

    override fun toString(): String {
        return "Name: $name, Species: ${species.name}, Age: ${getAge()}, Gender: $gender, Size: $sizeGroup"
    }
}