package main

import main.import.Importer
import main.zoo.Zoo

fun main() {
    val zoo = Zoo()
    zoo.restoreFoodList(Importer.importFoodFromJson(zoo))
    println("Imported food!")
    println("Number of foods: ${zoo.foodList.size}")

}