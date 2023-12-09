package main.zoo

import enclosure.Enclosure
import main.animal.Species
import main.food.Food

class Zoo {
    var enclosureList = mutableListOf<Enclosure>()
    var speciesList = mutableListOf<Species>()
    var foodList = mutableListOf<Food>()

    fun addEnclosure(enclosure: Enclosure) {
        enclosureList.add(enclosure)
        println("Added ${enclosure.name} to the zoo.")
    }

    fun addSpecies(species: Species) {
        speciesList.add(species)
        println("Added ${species.name} to the zoo.")
    }

    fun restoreSpeciesList(speciesList: List<Species>) {
         this.speciesList = speciesList.toMutableList()
     }

    fun addFood(food: Food) {
        foodList.add(food)
        println("Added ${food.name} to the zoo.")
    }

    fun restoreFoodList(foodList: List<Food>) {
         this.foodList = foodList.toMutableList()
     }
}