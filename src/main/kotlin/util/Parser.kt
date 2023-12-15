package main.util

import main.animal.Gender
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class Parser {
    // instead of static methods, we use a companion object
    companion object {
        fun parseDate(dateStr: String): LocalDate {
            return try {
                LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("d.M.yyyy"))
            } catch (e: DateTimeParseException) {
                throw IllegalArgumentException("Invalid date format. Expected format: d.M.yyyy")
            }
        }

        fun parseGender(genderStr: String): Gender {
            return when (genderStr.lowercase()) {
                "m" -> Gender.MALE
                "f" -> Gender.FEMALE
                else -> Gender.UNKNOWN
            }
        }
    }
}