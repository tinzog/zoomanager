package main.import

import kotlinx.serialization.json.Json
import main.animal.Species
import main.zoo.Zoo
import java.io.File

//By declaring an object in Kotlin we define a singleton, that is, a class with only one instance. Such an instance is created lazily, the first time it’s used, in a thread-safe manner.
object Importer {

        fun importSpeciesFromJson(zoo: Zoo): List<Species> {
            zoo.speciesList.clear()
            val jsonString = File("src/data/species.json").readText(Charsets.UTF_8)
            val speciesList = Json.decodeFromString<List<Species>>(jsonString)
            for (species in speciesList) {
                zoo.addSpecies(species)
                zoo.addFood(species.getDefaultFood())
            }
            return zoo.speciesList
        }
}