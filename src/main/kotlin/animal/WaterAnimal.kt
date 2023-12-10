package main.animal

import main.food.FeedingSchedule

enum class WaterType {
    FRESHWATER,
    SALTWATER
}
class WaterAnimal: Animal, Swimmable {
    var preferredWaterType: WaterType
    var requiredPoolSize: Int = 0

    constructor(
        name: String = "",
        species: Species,
        _dateOfBirth: String = "",
        feedingSchedule: FeedingSchedule = species.defaultFeedingSchedule,
        gender: Gender? = Gender.UNKNOWN,
        weight: Double? = null,
        waterType: WaterType? = WaterType.FRESHWATER,
        preferredPoolSize: Int = 0
    ) : super(name, species, _dateOfBirth, feedingSchedule, gender, weight) {
        // default is freshwater
        this.preferredWaterType = waterType ?: WaterType.FRESHWATER
        this.requiredPoolSize = preferredPoolSize
    }

    override fun getWaterType(): String {
        return this.preferredWaterType.toString()
    }

    override fun getMinimumPoolSize(): Int {
        if (this.sizeGroup == Sizegroup.SMALL) {
            return 100
        } else {
            return 1000
        }
    }
}
