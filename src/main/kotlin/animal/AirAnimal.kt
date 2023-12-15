package main.animal

import main.zoo.Zoo
import java.time.LocalDate

class AirAnimal : Animal, Flyable {

    var requiredEnclosureHeight: Int

    constructor(
        speciesName: String,
        enclosureName: String,
        zoo: Zoo,
        name: String? = null,
        dateOfBirth: LocalDate = LocalDate.now(),
        gender: Gender = Gender.UNKNOWN,
        weight: Int = 0,
        requiredEnclosureHeight: Int = 0,
    ) : super(
        speciesName = speciesName,
        enclosureName = enclosureName,
        zoo = zoo,
        name = name,
        dateOfBirth = dateOfBirth,
        gender = gender,
        weight = weight
    ) {
        this.requiredEnclosureHeight = requiredEnclosureHeight
    }

    override fun getMinimunEnclosureHeight(): Int {
        if (this.requiredEnclosureHeight == 0) {
            return if (this.sizeGroup == Sizegroup.SMALL) 5 else 10
        }
        return this.requiredEnclosureHeight
    }
}