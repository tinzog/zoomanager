package enclosure

import main.animal.Animal

class Enclosure {

    val name: String = "Enclosure"
    val animals = mutableListOf<Animal>()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
        println("Added ${animal.name} the ${animal.species} to the zoo.")
    }

    fun removeAnimal(animal: Animal) {
        animals.remove(animal)
        println("Removed ${animal.name} the ${animal.species} from the zoo.")
    }

    fun getAnimalList(): List<Animal> {
        return animals
    }

    fun getAnimalsToString(): String {
        var animalsString = ""
        animals.forEach { animal ->
            animalsString += "${animal.toString()}\n"
        }
        return animalsString
    }
}
