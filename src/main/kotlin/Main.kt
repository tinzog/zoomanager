package main

import animal.Animal
import enclosure.Enclosure
import utils.FileOperations

fun main() {
    val zoo = Enclosure()

    while (true) {
        println("Welcome to the Zoo Management System")
        println("1. Add an Animal")
        println("2. Remove an Animal")
        println("3. View all Animals")
        println("4. Export Animals to CSV")
        println("5. Import Animals from CSV")
        println("6. Exit")
        print("Choose an option: ")

        val input = readLine()

        when (input) {
            "1" -> {
                print("Enter animal name: ")
                val name = readLine() ?: ""
                print("Enter animal species: ")
                val species = readLine() ?: ""
                print("Enter animal age: ")
                val age = readLine()?.toIntOrNull() ?: 0
                zoo.addAnimal(Animal(name, species, age))
            }
            "2" -> {
                print("Enter name of animal to remove: ")
                val name = readLine() ?: ""
                // output error if animal not in list
                val animal = zoo.animals.find { it.name == name }
                if (animal == null) {
                    println("Animal not found.")
                    continue
                } else {
                    zoo.removeAnimal(animal)
                }
            }
            "3" -> {
                println("Animals in the zoo:")
                println("There are ${zoo.animals.size} animals in the zoo.")
                println("Details:")
                zoo.animals.forEach { animal ->
                    println("Name: ${animal.name}, Species: ${animal.species}")
                }
            }
            "4" -> {
                print("Enter filename to save to: ")
                val filename = readLine() ?: ""
                FileOperations.saveAnimalsToCsv(zoo.animals, filename)
            }
            "5" -> {
                print("Enter filename to load from: ")
                val filename = readLine() ?: ""
                val animals = FileOperations.loadAnimalsFromCsv(filename)
                zoo.animals.clear()
                zoo.animals.addAll(animals)
            }
            "6" -> {
                println("Thank you for using the Zoo Management System.")
                break
            }
            else -> println("Invalid option. Please try again.")
        }
    }
}