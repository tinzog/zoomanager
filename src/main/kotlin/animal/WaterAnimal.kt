package main.animal

import main.zoo.Zoo
import java.time.LocalDate

enum class WaterType {
    FRESHWATER,
    SALTWATER
}
class WaterAnimal: Animal, Swimmable {

    var preferredWaterType: WaterType = WaterType.FRESHWATER
    var requiredWaterDepth: Int = 1

    constructor(
        speciesName: String,
        enclosureName: String,
        zoo: Zoo,
        name: String? = null,
        dateOfBirth: LocalDate = LocalDate.now(),
        gender: Gender = Gender.UNKNOWN,
        weight: Int = 0,
        requiredEnclosureSize: Int = 0,
        preferredWaterType: WaterType = WaterType.FRESHWATER,
    ) : super(
        speciesName = speciesName,
        enclosureName = enclosureName,
        zoo = zoo,
        name = name,
        dateOfBirth = dateOfBirth,
        gender = gender,
        weight = weight
    ) {
        this.requiredWaterDepth = requiredEnclosureSize
        this.preferredWaterType = preferredWaterType
    }

    override fun getWaterType(): String {
        return this.preferredWaterType.toString()
    }

    override fun getMinimumPoolSize(): Int {
        if (this.requiredWaterDepth == 0) {
            return if (this.sizeGroup == Sizegroup.SMALL) 2 else 10
        }
        return this.requiredWaterDepth * 5
    }
}
