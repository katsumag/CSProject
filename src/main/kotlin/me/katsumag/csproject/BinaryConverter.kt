package me.katsumag.csproject

class BinaryConverter(private val binary: String) {

    private fun calculateBases() = binary.indices.map { 1 shl it }.toMutableList().asReversed()
    private fun calculateBases(newBinary: String) = newBinary.indices.map { 1 shl it }.toMutableList().asReversed()

    private fun calculateReciprocalBases(): List<Double> {
        val bases = calculateBases(binary + "0").asReversed()
        bases.removeAt(0)
        return bases.map { 1 / it.toDouble() }
    }

    private fun flipFirst(list: MutableList<Int>) = list.updated(0, list[0] * -1)

    private fun convertToDenary(bases: List<Number>): Double {
        var total = 0.0
        val table = (bases zip binary.map { Character.getNumericValue(it) }).toMap()

        table.entries.forEach {
            if (it.value == 1) {
                total += it.key.toDouble()
            }
        }

        return total

    }

    fun toDenary() = convertToDenary(calculateBases())
    fun toDenaryFirstNegative() = convertToDenary(flipFirst(calculateBases()))
    fun toDenaryReciprocals() = convertToDenary(calculateReciprocalBases())

}

fun <E> Iterable<E>.updated(index: Int, elem: E) = mapIndexed { i, existing ->  if (i == index) elem else existing }

fun insertString(insert: String, index: Int, string: String) = string.substring(0, index) + insert + string.substring(index, string.lastIndex+1)

fun shiftPoint(mantissa: String, exponent: Int): String {
    val parts = mantissa.split(".")
    return parts[0] + insertString(".", exponent, parts[1])
}