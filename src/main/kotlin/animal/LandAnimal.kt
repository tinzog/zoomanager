package main.animal

import kotlinx.serialization.Serializable
import main.food.FeedingSchedule

@Serializable
class LandAnimal : Animal, Walkable {

    var requiredEnclosureSize: Int
    // secondary constructor
    constructor(
        name: String = "",
        species: Species,
        _dateOfBirth: String = "",
        feedingSchedule: FeedingSchedule = species.defaultFeedingSchedule,
        gender: Gender? = Gender.UNKNOWN,
        weight: Double? = null,
        enclosureSize: Int = 0
    ) : super(name, species, _dateOfBirth, feedingSchedule, gender, weight) {
        this.requiredEnclosureSize = enclosureSize
    }

    override fun getMinimumEnclosureSize(): Int {
        if (this.requiredEnclosureSize == 0) {
            // if sizeGroup is SMALL, return 10, else return 100
            return if (this.sizeGroup == Sizegroup.SMALL) 100 else 1000
        }
        return this.requiredEnclosureSize
    }
}