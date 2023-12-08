package utils

import animal.Animal
import java.io.File

object FileOperations {
    fun saveAnimalsToCsv(animals: List<Animal>, filename: String) {
        // change file path to data
        val path = "data/" + filename + ".csv"
        try {
            File(path).bufferedWriter().use { out ->
                animals.forEach { animal ->
                    out.write(animal.toCsv())
                    out.newLine()
                }
            }
            println("Animals saved to $path")
        } catch (e: Exception) {
            println("Error saving animals to CSV: ${e.message}")
        }
    }

    fun loadAnimalsFromCsv(filename: String): List<Animal> {
        val file = File(filename)
        val animalsList = mutableListOf<Animal>()

        if (!file.exists()) {
            println("File does not exist at ${file.absolutePath}. A new file will be created upon saving.")
            return animalsList
        }

        try {
            file.forEachLine { line ->
                Animal.fromCsv(line)?.let {
                    animalsList.add(it)
                } ?: println("Invalid data found and skipped: $line")
            }
        } catch (e: Exception) {
            println("Error loading animals from CSV: ${e.message}")
        }

        return animalsList
    }
}
