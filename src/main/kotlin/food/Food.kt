package main.food

import kotlinx.serialization.Serializable

enum class Category {
    PLANT, ANIMAL
}

enum class FoodUnit {
    KG, G, L, ML, PIECE
}

@Serializable
abstract class Food(val name: String, val category: Category, val foodUnit: FoodUnit = FoodUnit.PIECE) {
    override fun toString(): String {
        return name
    }
}