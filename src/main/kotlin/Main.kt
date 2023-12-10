package main

import main.import.Importer
import main.zoo.Zoo

fun main() {
    val zoo = Zoo()
    zoo.restoreSpeciesList(Importer.restoreZooDataFromJson(zoo))

    while (true) {
        println("1. Show all species")
        println("2. Show all enclosures with their animals")
        println("3. Show all foods")
        println("4. Add or remove an animal")
        println("5. Exit")
        print("Enter your choice: ")
        val choice = readLine()!!.toInt()
        when (choice) {
            1 -> zoo.speciesList.forEach { println(it.name) }
            2 -> zoo.enclosureList.forEach { println(it.name) }
            3 -> zoo.foodList.forEach { println(it.name) }
            4 -> {
                println("Not implemented yet")
            }
            5 -> return
            else -> println("Invalid choice")
        }
    }
}