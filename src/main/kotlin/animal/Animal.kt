package main.animal

import kotlinx.serialization.Serializable
import main.food.FeedingSchedule
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

enum class Gender {
    MALE, FEMALE, UNKNOWN
}

enum class Sizegroup {
    SMALL, LARGE, UNKNOWN
}


@Serializable
abstract class Animal(
    val name: String = "",
    val species: Species,
    private var _dateOfBirth: String = "",
    val feedingSchedule: FeedingSchedule = species.defaultFeedingSchedule,
    val gender: Gender? = Gender.UNKNOWN,
    val weight: Double? = null,
    val enclosureName: String = ""
) {
    var dateOfBirth: String = _dateOfBirth
        get() = field
        private set(value) {
            if (!isValidDate(value)) {
                throw IllegalArgumentException("Invalid date format. Expected format: d.M.yyyy")
            }
            field = value
        }

    init {
        this.dateOfBirth = _dateOfBirth  // Validate the date format on initialization
    }

    private fun isValidDate(dateStr: String): Boolean {
        return try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("d.M.yyyy"))
            true
        } catch (e: DateTimeParseException) {
            false
        }
    }

    fun getAge(): Int {
        val birthDate = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("d.M.yyyy"))
        val today = LocalDate.now()
        return today.year - birthDate.year - if (today.dayOfYear < birthDate.dayOfYear) 1 else 0
    }

    val sizeGroup: Sizegroup
        get() = weight?.let { if (it < 10) Sizegroup.SMALL else Sizegroup.LARGE } ?: Sizegroup.UNKNOWN

    override fun toString(): String {
        return "Name: $name, Species: ${species.toString()}, Age: ${getAge()}, Gender: $gender, Size: $sizeGroup"
    }
}