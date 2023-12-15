package enclosure

import main.animal.*

class Enclosure (val name: String) {
    val landAnimals = mutableListOf<LandAnimal>()
    val airAnimals = mutableListOf<Animal>()
    val waterAnimals = mutableListOf<Animal>()
    var enclosureSizeLand = 0
    var enclosureSizeSaltWater = 0
    var enclosureSizeFreshWater = 0
    var enclosureHeightAir = 0
    var capacitySmallLandAnimals = 0
    var capacityLargeLandAnimals = 0
    var capacitySmallAirAnimals = 0
    var capacityLargeAirAnimals = 0
    var capacitySmallWaterAnimals = 0
    var capacityLargeWaterAnimals = 0
    var containsWaterEnclosure = false
    var waterType = WaterType.FRESHWATER

    fun addAnimal(animal: Animal) {
        // if LandAnimal is added, add to landAnimals
        if (animal is LandAnimal) {
            landAnimals.add(animal)
        } else if (animal is AirAnimal) {
            airAnimals.add(animal)
        } else if (animal is WaterAnimal) {
            waterAnimals.add(animal)
        }
        println("Added ${animal.name} the ${animal.species} to the enclosure ${this.name}.")
    }

    fun removeAnimal(animal: Animal) {
        if (animal is LandAnimal) {
            landAnimals.remove(animal)
        } else if (animal is AirAnimal) {
            airAnimals.remove(animal)
        } else if (animal is WaterAnimal) {
            waterAnimals.remove(animal)
        }
        println("Removed ${animal.name} the ${animal.species} from the enclosure ${this.name}.")
    }

    fun getAllAnimals(): List<Animal> {
        val animals = mutableListOf<Animal>()
        animals.addAll(landAnimals)
        animals.addAll(airAnimals)
        animals.addAll(waterAnimals)
        return animals
    }

    fun getNumberOfAnimals(): Int {
        return getAllAnimals().size
    }

    fun getNumberOfLandAnimals(): Int {
        return landAnimals.size
    }

    fun getNumberOfAirAnimals(): Int {
        return airAnimals.size
    }

    fun getNumberOfWaterAnimals(): Int {
        return waterAnimals.size
    }

    fun getLargeAnimals(): List<Animal> {
        val largeAnimals = mutableListOf<Animal>()
        largeAnimals.addAll(landAnimals.filter { it.sizeGroup == Sizegroup.LARGE })
        largeAnimals.addAll(airAnimals.filter { it.sizeGroup == Sizegroup.LARGE })
        largeAnimals.addAll(waterAnimals.filter { it.sizeGroup == Sizegroup.LARGE })
        return largeAnimals
    }

    /**
     * Returns the maximum filled capacity of the enclosure by any of the 6 possible animal types.
     * (large and small animals for land, water and air)
     */
    fun getMaxFilledCapacity(): Int {
        // calculate fill capacity of enclosure for large and small animals land, water and air
        val largeLandAnimals = landAnimals.filter { it.sizeGroup == Sizegroup.LARGE }.size
        val smallLandAnimals = landAnimals.filter { it.sizeGroup == Sizegroup.SMALL }.size
        val largeWaterAnimals = waterAnimals.filter { it.sizeGroup == Sizegroup.LARGE }.size
        val smallWaterAnimals = waterAnimals.filter { it.sizeGroup == Sizegroup.SMALL }.size
        val largeAirAnimals = airAnimals.filter { it.sizeGroup == Sizegroup.LARGE }.size
        val smallAirAnimals = airAnimals.filter { it.sizeGroup == Sizegroup.SMALL }.size

        val percentFillCapacity = listOf(
            largeLandAnimals.toDouble() / capacityLargeLandAnimals,
            smallLandAnimals.toDouble() / capacitySmallLandAnimals,
            largeWaterAnimals.toDouble() / capacityLargeWaterAnimals,
            smallWaterAnimals.toDouble() / capacitySmallWaterAnimals,
            largeAirAnimals.toDouble() / capacityLargeAirAnimals,
            smallAirAnimals.toDouble() / capacitySmallAirAnimals
        ).maxOrNull() ?: 0.0

        return (percentFillCapacity * 100).toInt()
    }
}
