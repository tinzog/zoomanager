package main.animal

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import main.food.FeedingSchedule

@Serializable
@SerialName("AirAnimal")
class AirAnimal : Animal, Flyable {

    var requiredEnclosureHeight: Int
    // secondary constructor
    constructor(
        name: String = "",
        species: Species,
        _dateOfBirth: String = "",
        feedingSchedule: FeedingSchedule = species.defaultFeedingSchedule,
        gender: Gender? = Gender.UNKNOWN,
        weight: Double? = null,
        enclosureName: String = "",
        requiredEnclosureHeight: Int = 0
    ) : super(name, species, _dateOfBirth, feedingSchedule, gender, weight, enclosureName) {
        this.requiredEnclosureHeight = requiredEnclosureHeight
    }

    override fun getMinimunEnclosureHeight(): Int {
        if (this.requiredEnclosureHeight == 0) {
            // if sizeGroup is SMALL, return 10, else return 100
            return if (this.sizeGroup == Sizegroup.SMALL) 5 else 10
        }
        return this.requiredEnclosureHeight
    }
}