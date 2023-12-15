package main.factory

import main.animal.WaterAnimal
import main.animal.WaterType
import main.util.Parser
import main.zoo.Zoo

class WaterAnimalFactory(private val zoo: Zoo) {
    fun createWaterAnimal(
        speciesName: String,
        enclosureName: String,
        zoo: Zoo,
        name: String?,
        dateOfBirthStr: String,
        genderStr: String,
        weight: Int?,
        requiredWaterDepth: Int,
        preferredWaterType: WaterType
    ): WaterAnimal {
        val dateOfBirth = Parser.parseDate(dateOfBirthStr)
        val gender = Parser.parseGender(genderStr)

        return WaterAnimal(
            speciesName = speciesName,
            enclosureName = enclosureName,
            zoo = zoo,
            name = name,
            dateOfBirth = dateOfBirth,
            gender = gender,
            weight = weight ?: 0,
            requiredWaterDepth,
            preferredWaterType
        )
    }
}