package main.factory

import main.animal.Species
import main.food.FeedingSchedule
import main.zoo.Zoo

class SpeciesFactory(private val zoo: Zoo) {
    fun createSpeciesList(
        speciesData: List<Triple<String, String, FeedingSchedule>>
    ): List<Species> {
        return speciesData.map { (genusName, speciesName, feedingSchedule) ->
            Species(genusName, speciesName, feedingSchedule)
        }
    }
}