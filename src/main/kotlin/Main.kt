package main

import main.import.Importer
import main.zoo.Zoo

fun main() {
    val zoo = Zoo()
    zoo.restoreSpeciesList(Importer.importSpeciesFromJson(zoo))
    println("Imported species!")
    println("Number of species: ${zoo.speciesList.size}")
    println("Number of foods: ${zoo.foodList.size}")
    // print all foods with uid and name
    zoo.foodList.forEach { println("${it.category}: ${it.name}") }
}