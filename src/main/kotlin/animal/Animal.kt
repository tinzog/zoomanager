package animal

class Animal(val name: String, val species: String, val age: Int) {
    companion object {
        fun fromCsv(csvLine: String): Animal? {
            val tokens = csvLine.split(",").map { it.trim() }
            // return if there are not exactly 3 columns corresponding to each property
            if (tokens.size != 3) return null
            val (name, species, age) = tokens
            return Animal(name, species, age.toIntOrNull() ?: return null)
        }
    }

    fun toCsv(): String = "$name,$species,$age"
}
