package enclosure

import animal.Animal

class Enclosure {
    val animals = mutableListOf<Animal>()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
        println("Added ${animal.name} the ${animal.species} to the zoo.")
    }

    fun removeAnimal(animal: Animal) {
        animals.remove(animal)
        println("Removed ${animal.name} the ${animal.species} from the zoo.")
    }
}
