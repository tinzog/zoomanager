package main.factory

import main.animal.AirAnimal
import main.animal.Animal
import main.util.Parser
import main.zoo.Zoo

class AirAnimalFactory(private val zoo: Zoo) {
    fun createAirAnimal(
        speciesName: String,
        enclosureName: String,
        zoo: Zoo,
        name: String?,
        dateOfBirthStr: String,
        genderStr: String,
        weight: Int?,
        requiredEnclosureHeight: Int,
    ): Animal {
        val dateOfBirth = Parser.parseDate(dateOfBirthStr)
        val gender = Parser.parseGender(genderStr)

        return AirAnimal(
            speciesName = speciesName,
            enclosureName = enclosureName,
            zoo = zoo,
            name = name,
            dateOfBirth = dateOfBirth,
            gender = gender,
            weight = weight ?: 0,
            requiredEnclosureHeight = requiredEnclosureHeight ?: 0
        )
    }
}