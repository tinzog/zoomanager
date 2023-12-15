package main.animal

import main.zoo.Zoo
import java.time.LocalDate

class LandAnimal : Animal, Walkable {

    var requiredEnclosureWidth: Int

    constructor(
        speciesName: String,
        enclosureName: String,
        zoo: Zoo,
        name: String? = null,
        dateOfBirth: LocalDate = LocalDate.now(),
        gender: Gender = Gender.UNKNOWN,
        weight: Int = 0,
        requiredEnclosureWidth: Int = 0
    ) : super(
        speciesName = speciesName,
        enclosureName = enclosureName,
        zoo = zoo,
        name = name,
        dateOfBirth = dateOfBirth,
        gender = gender,
        weight = weight
    ) {
        this.requiredEnclosureWidth = requiredEnclosureWidth
    }

    override fun getMinimumEnclosureSize(): Int {
        if (this.requiredEnclosureWidth == 0) {
            return if (this.sizeGroup == Sizegroup.SMALL) 10 else 100
        }
        // area
        return this.requiredEnclosureWidth * this.requiredEnclosureWidth
    }
}
