package main.zoo

import enclosure.Enclosure
import main.animal.Species
import main.animal.WaterType
import main.factory.AirAnimalFactory
import main.factory.LandAnimalFactory
import main.factory.SpeciesFactory
import main.factory.WaterAnimalFactory
import main.food.Category
import main.food.FeedingSchedule
import main.food.Food
import main.food.FoodUnit

object ZooCreator {
    public fun createZoo(): Zoo {
        val zoo = Zoo()
        val speciesFactory = SpeciesFactory(zoo)
        val landAnimalFactory = LandAnimalFactory(zoo)
        val airAnimalFactory = AirAnimalFactory(zoo)
        val waterAnimalFactory = WaterAnimalFactory(zoo)

        // create 3 different enclosures
        val enclosure1 = Enclosure("Cats of Prey")
        val enclosure2 = Enclosure("Polar")
        val enclosure3 = Enclosure("Aviary")

        // "Cats of Prey" can only hold land animals
        enclosure1.capacityLargeLandAnimals = 10
        enclosure1.capacitySmallLandAnimals = 50
        enclosure1.enclosureSizeLand = 1000

        // "Polar" can hold land and water animals
        enclosure2.containsWaterEnclosure = true
        enclosure2.waterType = WaterType.SALTWATER
        enclosure2.enclosureSizeSaltWater = 1000
        enclosure2.capacityLargeLandAnimals = 5
        enclosure2.capacitySmallLandAnimals = 20
        enclosure2.capacitySmallWaterAnimals = 50
        enclosure2.enclosureSizeLand = 900

        // "Aviary" can hold air animals
        enclosure3.enclosureHeightAir = 10
        enclosure3.capacityLargeAirAnimals = 10
        enclosure3.capacitySmallAirAnimals = 50

        val foods = listOf(
            Food("Meat", Category.ANIMAL, FoodUnit.KG),
            Food("Fish", Category.ANIMAL, FoodUnit.PIECE),
            Food("Fruits", Category.PLANT, FoodUnit.PIECE),
            Food("Nuts", Category.PLANT, FoodUnit.G),
            Food("Seeds", Category.PLANT, FoodUnit.G),
            Food("Insects", Category.ANIMAL, FoodUnit.G),
            Food("Plankton", Category.PLANT, FoodUnit.G),
            Food("Grass", Category.PLANT, FoodUnit.G),
            Food("Leaves", Category.PLANT, FoodUnit.G),
        )

        // create some foods with default units
        val meat = Food("Meat", Category.ANIMAL, FoodUnit.KG)
        val fish = Food("Fish", Category.ANIMAL, FoodUnit.PIECE)
        val fruit = Food("Fruit", Category.PLANT, FoodUnit.PIECE)
        val corn = Food("Corn", Category.PLANT, FoodUnit.G)
        val insects = Food("Insects", Category.ANIMAL, FoodUnit.G)
        val fishFood = Food("Fishfood", Category.PLANT, FoodUnit.G)

        // add foods to zoo
        zoo.addFood(meat)
        zoo.addFood(fish)
        zoo.addFood(fruit)
        zoo.addFood(corn)
        zoo.addFood(insects)
        zoo.addFood(fishFood)

        // Create feeding schedules
        val feedingScheduleLion = FeedingSchedule(2, meat, 2, "KG")
        val feedingScheduleTiger = FeedingSchedule(2, meat, 2, "KG")
        val feedingSchedulePolarBear = FeedingSchedule(2, fish, 4, "PIECE")
        val feedingSchedulePenguin = FeedingSchedule(3, fish, 200, "G")
        val feedingScheduleFish = FeedingSchedule(1, fishFood, 20, "G")
        val feedingScheduleBird = FeedingSchedule(1, corn, 50, "G")
        val feedingScheduleMeercat = FeedingSchedule(1, insects, 50, "G")


        val speciesList = listOf(
            Species("Panthera", "Leo", feedingScheduleLion),
            Species("Panthera", "Tigris", feedingScheduleTiger),
            Species("Ursus", "Maritimus", feedingSchedulePolarBear),
            Species("Spheniscus", "Demersus", feedingSchedulePenguin),
            Species("Pterois", "Volitans", feedingScheduleFish),
            Species("Ara", "Ararauna", feedingScheduleBird),
            Species("Suricata", "suricatta", feedingScheduleMeercat)
        )

        // Add species to the zoo
        speciesList.forEach { zoo.addSpecies(it) }

        val lion =
            landAnimalFactory.createLandAnimal("Panthera Leo", "Cats of Prey", zoo, "Leo", "15.05.2015", "M", 190, 100)

        // Enclosure 1
        val landAnimalData1 = listOf(
            listOf("Panthera Leo", "Cats of Prey", "Max", "15.05.2015", "M", 150, 100),
            listOf("Panthera Leo", "Cats of Prey", "Lilly", "15.05.2023", "F", 30, 100),
            listOf("Panthera Leo", "Cats of Prey", "Simba", "15.05.2018", "M", 190, 150),
            listOf("Panthera Tigris", "Cats of Prey", "Brittney", "20.08.2016", "F", 180, 100),
            listOf("Panthera Tigris", "Cats of Prey", "Stripe", "20.08.2019", "M", 130, 100),
            listOf("Suricata suricatta", "Cats of Prey", "Apollo", "20.09.2021", "M", 4, 50),
            listOf("Suricata suricatta", "Cats of Prey", "Filly", "20.79.2021", "F", 3, 50),
            listOf("Suricata suricatta", "Cats of Prey", "Odeon", "12.09.2020", "M", 4, 50),
            listOf("Suricata suricatta", "Cats of Prey", "Surry", "13.09.2019", "F", 3, 50),
        )

        this.addLandAnimalsToEnclosure(zoo, enclosure1, landAnimalData1, landAnimalFactory)

        // Enclosure 2
        // land animals
        val landAnimalData2 = listOf(
            listOf("Ursus Maritimus", "Polar", "Nanook", "15.05.2015", "M", 190, 100),
            listOf("Ursus Maritimus", "Polar", "Nora", "15.05.2023", "F", 30, 100),
            listOf("Ursus Maritimus", "Polar", "Nala", "15.05.2018", "F", 190, 150),
            listOf("Spheniscus Demersus", "Polar", "Pingu", "20.08.2016", "M", 180, 100),
            listOf("Spheniscus Demersus", "Polar", "Pinguin", "20.08.2019", "M", 130, 100),
            listOf("Spheniscus Demersus", "Polar", "Pippa", "20.09.2021", "F", 4, 50),
        )

        this.addLandAnimalsToEnclosure(zoo, enclosure2, landAnimalData2, landAnimalFactory)

        // fish
        for (i in 1..40) {
            val animal = waterAnimalFactory.createWaterAnimal(
                "Pterois Volitans",
                "Polar",
                zoo,
                "",
                "",
                "",
                null,
                10,
                WaterType.SALTWATER
            )
            enclosure2.addAnimal(animal)
        }

        // Enclosure 3
        val airAnimalData = listOf(
            listOf("Ara Ararauna", "Aviary", "Ara", "15.05.2015", "M", 190, 100),
            listOf("Ara Ararauna", "Aviary", "Ari", "15.05.2023", "F", 30, 100),
            listOf("Ara Ararauna", "Aviary", "Ariana", "15.05.2018", "F", 190, 150),
        )

        for (animalInfo in airAnimalData) {
            val animal = airAnimalFactory.createAirAnimal(
                animalInfo[0].toString(),
                animalInfo[1].toString(),
                zoo,
                animalInfo[2].toString(),
                animalInfo[3].toString(),
                animalInfo[4].toString(),
                animalInfo[5].toString().toInt(),
                10
            )
            enclosure3.addAnimal(animal)
        }

        // add enclosures to zoo
        zoo.addEnclosure(enclosure2)
        zoo.addEnclosure(enclosure2)
        zoo.addEnclosure(enclosure3)

        return zoo
    }

    fun addLandAnimalsToEnclosure(
        zoo: Zoo,
        enclosure: Enclosure,
        animalData: List<List<Any>>,
        animalFactory: LandAnimalFactory
    ) {
        for (animalInfo in animalData) {
            val animal = animalFactory.createLandAnimal(
                animalInfo[0].toString(),
                animalInfo[1].toString(),
                zoo,
                animalInfo[2].toString(),
                animalInfo[3].toString(),
                animalInfo[4].toString(),
                animalInfo[5].toString().toInt(),
                animalInfo[6].toString().toInt()
            )
            enclosure.addAnimal(animal)
        }
    }
}