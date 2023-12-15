package main.factory

import main.animal.Animal
import main.animal.LandAnimal
import main.util.Parser
import main.zoo.Zoo

class LandAnimalFactory(private val zoo: Zoo)  {
    fun createLandAnimal(
        speciesName: String,
        enclosureName: String,
        zoo: Zoo,
        name: String?,
        dateOfBirthStr: String,
        genderStr: String,
        weight: Int?,
        requiredEnclosureWidth: Int,
    ): Animal {
        val dateOfBirth = Parser.parseDate(dateOfBirthStr)
        val gender = Parser.parseGender(genderStr)
        val enclosure = zoo.getEnclosureByName(enclosureName)
            ?: throw IllegalArgumentException("Enclosure $enclosureName does not exist.")

        return LandAnimal(
            speciesName = speciesName,
            enclosureName = enclosureName,
            zoo = zoo,
            name = name,
            dateOfBirth = dateOfBirth,
            gender = gender,
            weight = weight ?: 0,
            requiredEnclosureWidth = requiredEnclosureWidth
        )
    }
}