package me.katsumag.csproject

class BinaryConverter(private val binary: String) {

    fun convert(exponent: Boolean): Int {

        val reference = binary.indices.map { 1 shl it }.toMutableList()

        val convertedBinary = binary.reversed().map { Character.getNumericValue(it) }

        if (exponent) reference[reference.lastIndex] *= -1

        val result = reference zip convertedBinary
        val table = result.toMap()

        println(reference)
        println(table)

        var total = 0

        table.entries.forEach {
            if (it.value == 1) {
                total += it.key
            }
        }

        return total
    }
}
