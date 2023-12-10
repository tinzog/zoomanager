package main.import

import enclosure.Enclosure
import kotlinx.serialization.json.Json
import main.animal.Species
import main.zoo.Zoo
import java.io.File

//By declaring an object in Kotlin we define a singleton, that is, a class with only one instance. Such an instance is created lazily, the first time it’s used, in a thread-safe manner.
object Importer {

        fun restoreZooDataFromJson(zoo: Zoo): Zoo {
            // import enclosure data
            zoo.enclosureList.clear()
            val enclosureJson = File("src/data/enclosures.json").readText(Charsets.UTF_8)
            val enclosures = Json.decodeFromString<List<Enclosure>>(enclosureJson)
            for (enclosure in enclosures) {
                zoo.addEnclosure(enclosure)
            }
            zoo.speciesList.clear()
            zoo.foodList.clear()
            val jsonString = File("src/data/species.json").readText(Charsets.UTF_8)
            val speciesList = Json.decodeFromString<List<Species>>(jsonString)
            for (species in speciesList) {
                zoo.addSpecies(species)
                zoo.addFood(species.getDefaultFood())
            }
            // TODO: restore the whole zoo data: enclosures, animals, feeding schedules, foods
            return zoo
        }
}